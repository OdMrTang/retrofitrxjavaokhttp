package com.applicatio.retrorxjavaokhttp.base;


import com.applicatio.retrorxjavaokhttp.transformer.ErrorTransformer;

import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by LiJiangLong on 2017/11/3.
 * 预处理处理异常
 */

public class RxSchedulers<T> implements ObservableTransformer<BaseHttpResult<T>,T>{
    @Override
    public ObservableSource<T> apply(io.reactivex.Observable<BaseHttpResult<T>> observable) {
        return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                .compose(ErrorTransformer.<T>getInstance());
    }


}
