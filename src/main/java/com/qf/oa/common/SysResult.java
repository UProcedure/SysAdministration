package com.qf.oa.common;

/**
 * @Author chenzetao
 * @Date 2019/9/27
 */
public class SysResult {
    private boolean result;//操作是否成功，成功：true  失败：false
    private String data;//提示信息

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
