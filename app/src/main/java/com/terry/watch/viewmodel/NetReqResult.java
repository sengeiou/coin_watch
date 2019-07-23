package com.terry.watch.viewmodel;

/**
 * 接口刷新结果
 *
 * @author 张全
 */
public class NetReqResult {
    public String tag; //区分请求
    public String message; //失败提示信息
    public boolean successful; //成功或失败
    public Object data;

    public NetReqResult(String tag, String message, boolean successful) {
        this(tag, message, successful, null);
    }

    public NetReqResult(String tag, String message, boolean successful, Object data) {
        this.tag = tag;
        this.message = message;
        this.successful = successful;
        this.data = data;
    }

}
