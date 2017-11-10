package com.applicatio.retrorxjavaokhttp.subscriber;

import android.content.Context;


import com.applicatio.retrorxjavaokhttp.base.EmptyLayout;
import com.applicatio.retrorxjavaokhttp.base.RoundProcessDialog;
import com.applicatio.retrorxjavaokhttp.utils.LogUtils;
import com.applicatio.retrorxjavaokhttp.utils.NetworkUtil;
import com.applicatio.retrorxjavaokhttp.utils.ToastUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by tang on 17/8/17.
 */

public abstract class CommonSubscriber<T> implements Observer<T>{

    private Context context;

    private EmptyLayout emptyLayout;

    private RoundProcessDialog dialog;


    public CommonSubscriber(Context context) {
        this.context = context;
        dialog = new RoundProcessDialog(context);
        if (emptyLayout == null)
            emptyLayout = new EmptyLayout(context);
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            ToastUtil.setToast("网络不可用");
        }
    }

    @Override
    public void onError(Throwable e) {
        if (!NetworkUtil.isNetworkAvailable(context))
            emptyLayout.showInError();
        else
            emptyLayout.showError();
        dialog.discussDialog();
    }

    @Override
    public void onNext(Object o) {
        //没内容
        dialog.discussDialog();
        if (o==null)
            emptyLayout.showEmpty();
        else
            emptyLayout.goneAll();
        onSucess(o);
    }

    @Override
    public void onComplete() {
        dialog.discussDialog();

    }

    protected abstract void onSucess(Object onject);


}
