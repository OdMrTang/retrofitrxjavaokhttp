package com.applicatio.retrorxjavaokhttp.utils;

import android.widget.Toast;

import com.applicatio.retrorxjavaokhttp.ProApplication;


/**
 * Created by tang on 17/8/17.
 */

public class ToastUtil {
    public static Toast toast;

    public static void setToast(String str) {

        if (toast == null) {
            toast = Toast.makeText(ProApplication.getmContext(), str, Toast.LENGTH_SHORT);
        } else {
            toast.setText(str);
        }
        toast.show();
    }
}
