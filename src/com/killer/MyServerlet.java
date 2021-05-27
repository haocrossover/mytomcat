package com.killer;

/**
 * Created by killer on 21-5-18.
 */
public class MyServerlet implements MyHttpServerlet {
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) throws Exception {
        myResponse.write("get mytomcat");
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) throws Exception{
        myResponse.write("post mytomcat");

    }
}
