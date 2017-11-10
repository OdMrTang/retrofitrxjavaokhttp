package com.applicatio.retrorxjavaokhttp.transformer;



import com.applicatio.retrorxjavaokhttp.base.BaseHttpResult;
import com.applicatio.retrorxjavaokhttp.exception.ErrorType;
import com.applicatio.retrorxjavaokhttp.exception.ExceptionEngine;
import com.applicatio.retrorxjavaokhttp.exception.ServerException;
import com.applicatio.retrorxjavaokhttp.utils.LogUtils;

import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by tang on 17/8/17.
 */

public class ErrorTransformer<T> implements ObservableTransformer<BaseHttpResult<T>, T> {

    private static ErrorTransformer errorTransformer = null;
    private static final String TAG = "ErrorTransformer";

    /**
     * @return 线程安全, 双层校验
     */
    public static <T> ErrorTransformer<T> getInstance() {

        if (errorTransformer == null) {
            synchronized (ErrorTransformer.class) {
                if (errorTransformer == null) {
                    errorTransformer = new ErrorTransformer<>();
                }
            }
        }
        return errorTransformer;

    }


    @Override
    public ObservableSource<T> apply(io.reactivex.Observable<BaseHttpResult<T>> observable) {
        return observable.map(new Function<BaseHttpResult<T>, T>() {
            @Override
            public T apply(@NonNull BaseHttpResult<T> tBaseHttpResult) throws Exception {
                if (tBaseHttpResult == null)
                    throw new ServerException(ErrorType.EMPTY_BEAN, "解析对象为空");

                LogUtils.e(TAG, tBaseHttpResult.toString());
                if (tBaseHttpResult.getResultcode() != ErrorType.SUCCESS)
                    throw new ServerException(tBaseHttpResult.getResultcode(), tBaseHttpResult.getReason());
                return tBaseHttpResult.getResult();
            }
        }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends T>>() {
            @Override
            public ObservableSource<? extends T> apply(@NonNull Throwable throwable) throws Exception {
                //ExceptionEngine为处理异常的驱动器throwable
                throwable.printStackTrace();
                return io.reactivex.Observable.error(ExceptionEngine.handleException(throwable));
            }
        });
    }
}
