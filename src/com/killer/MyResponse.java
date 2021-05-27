package com.killer;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by killer on 21-5-18.
 */
public class MyResponse {
    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String str) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HTTP/1.1 200 OK\n")
                .append("Content-Type:text/html\n")
                .append("\r\n")
                .append("<html>")
                .append("<body>")
                .append("<h1>" + str + "</h1>")
                .append("</body>")
                .append("</html>");
        this.outputStream.write(stringBuffer.toString().getBytes());
        this.outputStream.flush();
        this.outputStream.close();
    }
}
