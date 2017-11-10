package com.applicatio.retrorxjavaokhttp.base;



import com.applicatio.retrorxjavaokhttp.exception.ApiException;
import com.applicatio.retrorxjavaokhttp.utils.LogUtils;

import io.reactivex.Observer;


/**
 * Created by tang on 17/8/17.
 */

public abstract class BaseSubscriber<T> implements Observer {

    @Override
    public void onError(Throwable e) {
        ApiException apiException = (ApiException) e;
        onError(apiException);
    }

    @Override
    public void onNext(Object o) {
        LogUtils.e("", "网络可用");
    }

    /**
     * @param e 错误的一个回调
     */
    protected abstract void onError(ApiException e);

}
