package com.applicatio.retrorxjavaokhttp.base;

/**
 * Created by Tang on 17/8/18.
 * 抽取的一个基类的bean,直接在泛型中传data就行
 * 下面属性根据需求自己定义，注意result不能乱定义如果实际数据为data则定义为data
 */

public class BaseHttpResult<T> {

    private int error_code;

    private int resultcode;

    private String reason;

    private T result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public int getResultcode() {
        return resultcode;
    }

    public void setResultcode(int resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BaseHttpResult{" +
                "status=" + resultcode +
                ", message='" + reason + '\'' +
                ", data=" + result +
                '}';
    }
}
