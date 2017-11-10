package com.applicatio.retrorxjavaokhttp.base;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;

import com.applicatio.retrorxjavaokhttp.R;

/**
 * Created by Tang on 2017/8/30.
 */

public class RoundProcessDialog {

    private Dialog mDialog;

    public RoundProcessDialog(Context mcontext) {
        showDialog(mcontext);
    }

    public void showDialog(Context mContext)
    {
        mDialog = new AlertDialog.Builder(mContext).create();
        mDialog.show();
        // 注意此处要放在show之后 否则会报异常
        mDialog.setContentView(R.layout.loading_process_dialog_anim);
    }

    public void discussDialog(){
        mDialog.dismiss();
    }
}
