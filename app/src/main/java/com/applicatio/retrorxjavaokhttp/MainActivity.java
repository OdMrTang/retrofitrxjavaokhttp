package com.applicatio.retrorxjavaokhttp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.applicatio.retrorxjavaokhttp.base.CallBack;
import com.applicatio.retrorxjavaokhttp.bean.ResultBeans;
import com.applicatio.retrorxjavaokhttp.bean.Type;
import com.applicatio.retrorxjavaokhttp.http.TestModels;

public class MainActivity extends Activity {

    TextView tvcontent,tvwcontent,tvnoIn,tverror;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvcontent = (TextView) findViewById(R.id.clickss);
        tvwcontent= (TextView) findViewById(R.id.tv_weather);
        tvnoIn= (TextView) findViewById(R.id.tv_weathercontent);
        tverror= (TextView) findViewById(R.id.clickerror);


        findViewById(R.id.tv_weather).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testQuestion();
            }
        });

        tvwcontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Type.testkey="9c50c7766e008585";
                testQuestion();
            }
        });

        tvcontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testQuestion();
            }
        });

        tvnoIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testQuestion();
            }
        });

        tverror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Type.testkey="123";
                testQuestion();
            }
        });
    }


    void testQuestion(){

        new TestModels().test(new CallBack() {
            @Override
            public void OnSuccess(Object data) {
                ResultBeans beans = (ResultBeans) data;
                Toast.makeText(MainActivity.this,""+beans.getList().get(0).getQuestion(),Toast.LENGTH_SHORT).show();
            }
        },MainActivity.this);

    }
}
