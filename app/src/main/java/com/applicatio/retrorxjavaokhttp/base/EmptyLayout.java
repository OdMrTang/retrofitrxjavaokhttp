package com.applicatio.retrorxjavaokhttp.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.applicatio.retrorxjavaokhttp.R;

import java.util.ArrayList;
import java.util.List;

/**
 *  空页面 错误页面 数据加载中 展示
 *
 * Created by quanke(http://quanke.name) on 2016/4/5.
 */
public class EmptyLayout extends RelativeLayout{


//    private ViewGroup mLoadingView;
    private ViewGroup mEmptyView;
    private ViewGroup mErrorView;
    private ViewGroup mInError;

//    private TextView mLoadingMessageView;
    private TextView mEmptyMessageView;
    private TextView mErrorMessageView;
    private TextView mErrorInMessageView;


    private RelativeLayout mEmptyRelativeLayout;
    private int mErrorMessageViewId;
    private int mEmptyMessageViewId;
    private int mInerrorMessageViewId;
    private LayoutInflater mInflater;
    private boolean mViewsAdded;
    private int mLoadingAnimationViewId;

    /**
     * The empty state
     */
    public final static int TYPE_EMPTY = 1;
    /**
     * The loading state
     */
    public final static int TYPE_LOADING = 2;
    /**
     * The error state
     */
    public final static int TYPE_ERROR = 3;

    /**
     * The error state
     */
    public final static int TYPE_InERROR = 4;

    // ---------------------------
    // default values
    // ---------------------------
    private int mEmptyType = TYPE_LOADING;
    private int mErrorDrawable = R.drawable.ic_error;
    private int mEmptyDrawable = R.drawable.ic_empty;
    private int mLoadingDrawable = R.drawable.ic_loading;

    private String mErrorMessage = "哎呀！发生了一些错误";
    private String mEmptyMessage = "啥也没有";
    private String mInErrorMessage = "哎呀！网络错误了";


    private List<View> childViews;

    private LinearLayout layout;

    private Activity mcontext;

    public EmptyLayout(Context context) {
        super(context);
        mcontext = (Activity) context;
        init();
    }


    public EmptyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mcontext = (Activity) context;
        init();
    }

    public EmptyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mcontext = (Activity) context;
        init();
    }

    private void init(){
        childViews = new ArrayList<>();
        getChildViews();
        mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 设置Loading的图片
     * @param mLoadingDrawable 错误Loading资源id
     */
    public void setLoadingDrawable(int mLoadingDrawable) {
        this.mLoadingDrawable = mLoadingDrawable;
    }

    private void getChildViews(){
        int childCount = getChildCount();
        View view;
        for (int i=0;i<childCount;i++){
            view = getChildAt(i);
            if (isEmptyView(view)){
                continue;
            }
            childViews.add(view);
        }
    }

    private void hideChildView(){
        for (View view: childViews ) {
            if (isEmptyView(view)){
                continue;
            }
            view.setVisibility(GONE);
        }
    }

    /**
     * 判断view 对象是否是EmptyView
     * @param view
     * @return
     */
    private boolean isEmptyView(View view){
        if ((view == null||mEmptyRelativeLayout == view ||view == mEmptyView||view == mErrorView)){
            return true;
        }
        return false;
    }

    private void showChildView(){
        for (View view: childViews ) {
            if (isEmptyView(view)){
                continue;
            }
            view.setVisibility(VISIBLE);
        }
    }

    /**
     * 隐藏EmptyView
     */
    private void hideEmptyView(){

        if (mEmptyView != null){
            mEmptyView.setVisibility(GONE);
        }

        if (mErrorView != null){
            mErrorView.setVisibility(GONE);
        }
    }

    public void showError(){
        getChildViews();
        hideChildView();
        this.mEmptyType = TYPE_ERROR;
        changeEmptyType();
    }


    public void showEmpty(){

        getChildViews();
        hideChildView();
        this.mEmptyType = TYPE_EMPTY;
        changeEmptyType();

    }

    public void showInError(){

        getChildViews();
        hideChildView();
        this.mEmptyType = TYPE_InERROR;
        changeEmptyType();

    }

    public void goneAll(){
        getChildViews();
        hideChildView();
        this.mEmptyType = TYPE_LOADING;
        changeEmptyType();
    }

    /**
     *隐藏EmptyLayout
     */
    public void hide(){
        showChildView();
        hideEmptyView();
    }

    private void changeEmptyType() {

        setDefaultValues();
        refreshMessages();

        if (layout==null && mcontext.findViewById(R.id.main_rl)!=null)
            layout = (LinearLayout) mcontext.findViewById(R.id.main_rl);
//        layout.removeAllViews();
        // insert views in the root view
        mEmptyRelativeLayout = (RelativeLayout) layout.getTag();
        if (!mViewsAdded && layout!=null) {
            if (mEmptyRelativeLayout==null ) {
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                lp.addRule(RelativeLayout.CENTER_IN_PARENT);
                mEmptyRelativeLayout = new RelativeLayout(getContext());
                mEmptyRelativeLayout.setGravity(Gravity.CENTER);
                mEmptyRelativeLayout.setLayoutParams(lp);
                if (mEmptyView != null) mEmptyRelativeLayout.addView(mEmptyView);
                if (mErrorView != null)
                    mEmptyRelativeLayout.addView(mErrorView);
                if (mInError != null) mEmptyRelativeLayout.addView(mInError);
                layout.addView(mEmptyRelativeLayout);
                layout.setTag(mEmptyRelativeLayout);
            }else{
                mEmptyRelativeLayout.removeAllViews();
                if (mEmptyView != null) mEmptyRelativeLayout.addView
                        (mEmptyView);
                if (mErrorView != null)
                    mEmptyRelativeLayout.addView(mErrorView);
                if (mInError != null) mEmptyRelativeLayout.addView(mInError);
            }
            mViewsAdded = true;
            mEmptyRelativeLayout.setVisibility(VISIBLE);
        }

        switch (mEmptyType) {
                case TYPE_EMPTY:
                    if (mInError!=null) mInError.setVisibility(View.GONE);
                    if (mEmptyView!=null) mEmptyView.setVisibility(View.VISIBLE);
                    if (mErrorView!=null) mErrorView.setVisibility(View.GONE);
                    break;

                case TYPE_ERROR:
                    if (mInError!=null) mInError.setVisibility(View.GONE);
                    if (mEmptyView!=null) mEmptyView.setVisibility(View.GONE);
                    if (mErrorView!=null)
                        mErrorView.setVisibility(View.VISIBLE);
                    break;
                case TYPE_LOADING:
                    //隐藏所有
                    if (mInError!=null) mInError.setVisibility(View.GONE);
                    if (mEmptyView!=null) mEmptyView.setVisibility(View.GONE);
                    if (mErrorView!=null) mErrorView.setVisibility(View.GONE);
                    break;
                case TYPE_InERROR:
                    if (mEmptyView!=null) mEmptyView.setVisibility(View.GONE);
                    if (mErrorView!=null) mErrorView.setVisibility(View.GONE);
                    if (mInError!=null) mInError.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        if (layout!=null && mEmptyRelativeLayout!=null){
            layout.setTag(mEmptyRelativeLayout);
        }
    }

    /**
     * 清除加载重复的View
     * */
    void clearView(){
        for (int i = 0; i < layout.getChildCount(); i++) {
            if (layout.getChildAt(i) == mEmptyRelativeLayout){
                layout.removeView(mEmptyRelativeLayout);
            }
        }
    }


    /*展示view*/
    private void refreshMessages() {

        if (mEmptyMessageViewId>0 && mEmptyMessage!=null) {
            mEmptyMessageView = ((TextView)mEmptyView.findViewById(mEmptyMessageViewId));
            mEmptyMessageView.setText(mEmptyMessage);
            setTopDrawables(mEmptyMessageView, mEmptyDrawable);

        }
//        if (mLoadingMessageViewId>0 && mLoadingMessage!=null) {
//            mLoadingMessageView =  ((TextView)mLoadingView.findViewById(mLoadingMessageViewId));
//            mLoadingMessageView .setText(mLoadingMessage);
////            setTopDrawables(mLoadingMessageView,mLoadingDrawable);// loading 不能已经有loading image view ，不能直接设置TopDrawable
//        }
        if (mErrorMessageViewId>0 && mErrorMessage!=null){
            mErrorMessageView = ((TextView)mErrorView.findViewById(mErrorMessageViewId));
            mErrorMessageView.setText(mErrorMessage);
            setTopDrawables(mErrorMessageView,mErrorDrawable);
        }
        if (mInerrorMessageViewId>0 && mInErrorMessage!=null){
            mErrorInMessageView = ((TextView)mInError.findViewById(mInerrorMessageViewId));
            mErrorInMessageView.setText(mInErrorMessage);
            setTopDrawables(mErrorInMessageView,mErrorDrawable);
        }
    }


    private void setTopDrawables(TextView textView,int resId){
        Drawable drawable = getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());//必须设置图片大小，否则不显示
        textView.setCompoundDrawables(null,drawable,null,null);
    }

    /*设置默认view*/
    private void setDefaultValues() {
        if (mEmptyView==null) {
            mEmptyView = (ViewGroup) mInflater.inflate(R.layout.view_empty, null);
            if (!(mEmptyMessageViewId>0)) mEmptyMessageViewId = R.id.textViewMessage;
        }
        if (mErrorView==null) {
            mErrorView = (ViewGroup) mInflater.inflate(R.layout.view_error, null);
            if (!(mErrorMessageViewId>0)) mErrorMessageViewId = R.id.textViewMessage;
        }
        if (mInError==null){
            mInError = (ViewGroup) mInflater.inflate(R.layout.view_nointer_empty, null);
            if (!(mInerrorMessageViewId>0)) mInerrorMessageViewId = R.id.textViewInMessage;
        }
    }
}
