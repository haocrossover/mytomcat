package com.killer;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by killer on 21-5-18.
 */
public class MyRequest {
    //请求方法
    private String requestMethod;

    //请求地址
    private String requestUri;

    public MyRequest(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        String str = null;

        if ((len = inputStream.read(buffer)) > 0) {
            str = new String(buffer, 0, len);
        }
        String data=str.split("\n")[0];

        String[] params=data.split(" ");
        this.requestMethod=params[0];
        this.requestUri=params[1];
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }
}
