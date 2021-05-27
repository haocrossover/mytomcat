package com.killer;

/**
 * Created by killer on 21-5-18.
 */
public interface MyHttpServerlet {
    public static final String METHOD_GET="GET";
    public static final String METHOD_POST="POST";
    public abstract void doGet(MyRequest myRequest, MyResponse myResponse) throws Exception;
    public abstract void doPost(MyRequest myRequest, MyResponse myResponse) throws Exception;
    public default void service(MyRequest myRequest, MyResponse myResponse) throws Exception{
        if(METHOD_GET.equals(myRequest.getRequestMethod())) {
           doGet(myRequest,myResponse);
        } else if (METHOD_POST.equals(myRequest.getRequestMethod())) {
            doPost(myRequest, myResponse);
        }
    }
}
