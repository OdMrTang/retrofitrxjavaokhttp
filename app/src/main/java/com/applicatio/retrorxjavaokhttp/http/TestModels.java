package com.applicatio.retrorxjavaokhttp.http;

import android.content.Context;
import android.support.annotation.NonNull;

import com.applicatio.retrorxjavaokhttp.base.CallBack;
import com.applicatio.retrorxjavaokhttp.base.RxSchedulers;
import com.applicatio.retrorxjavaokhttp.bean.ResultBeans;
import com.applicatio.retrorxjavaokhttp.bean.Type;
import com.applicatio.retrorxjavaokhttp.subscriber.CommonSubscriber;


/**
 * Created by tang on 2017/8/23.
 */

public class TestModels {

    private HttpService httpService;

    public TestModels(){
        httpService = Http.getHttpService();
    }

    public void test(@NonNull final CallBack callback, Context mcontext){
        if (callback == null)
            throw new RuntimeException("callback");
        httpService.test(Type.testkey,Type.testtype,Type.intsubject+"",Type.pagesize+"",Type.pagenum+"",Type.sort)
                .compose(new RxSchedulers<ResultBeans>())
                .subscribe(new CommonSubscriber<ResultBeans>(mcontext){

                    @Override
                    protected void onSucess(Object onject) {
                        callback.OnSuccess(onject);
                    }
                });

    }

}
