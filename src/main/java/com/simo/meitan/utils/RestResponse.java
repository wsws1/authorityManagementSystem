package com.simo.meitan.utils;

public class RestResponse {

    private int code;

    private String msg;

    private Object data;

    public
    RestResponse() {

    }

    public static RestResponse succuess() {
        RestResponse restResponse = new RestResponse();
        restResponse.setResultCode(ResultCode.SUCCESS);

        return restResponse;
    }

    public static RestResponse succuess(Object data) {
        RestResponse restResponse = new RestResponse();
        restResponse.setResultCode(ResultCode.SUCCESS);
        restResponse.setData(data);

        return restResponse;
    }
    public static RestResponse succuess(Object data,String msg) {
        RestResponse restResponse = new RestResponse();
        restResponse.setResultCode(ResultCode.SUCCESS);
        restResponse.setData(data);
        restResponse.setMsg(msg);
        return restResponse;
    }

    public static RestResponse fail() {
        RestResponse restResponse = new RestResponse();
        restResponse.setResultCode(ResultCode.FAIL);

        return restResponse;
    }


    public static RestResponse fail(ResultCode resultCode) {
        RestResponse restResponse = new RestResponse();
        restResponse.setResultCode(resultCode);

        return restResponse;
    }

    public static RestResponse fail(String msg) {
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(ResultCode.FAIL.code());
        restResponse.setMsg(msg);

        return restResponse;
    }

    public static RestResponse fail(Integer code, String msg) {
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(code);
        restResponse.setMsg(msg);

        return restResponse;
    }

    public static RestResponse fail(ResultCode resultCode, Object data) {
        RestResponse restResponse = new RestResponse();
        restResponse.setResultCode(resultCode);
        restResponse.setData(data);

        return restResponse;
    }

    private void setResultCode(ResultCode resultCode) {
        this.code = resultCode.code();
        this.msg = resultCode.message();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
