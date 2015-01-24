package com.itbox.youzh.girls.net;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by youzh on 2014/12/25.
 */
public class Net {

    protected static OkHttpClient okHttpClient;
    protected static final MediaType JSON = MediaType.parse("text/html; charset=utf-8");

    static {
        okHttpClient = new OkHttpClient();
    }


    public static String get(String url) {

        Request request = new Request.Builder().url(url).build();
        try {
            Response  response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
//
//    public static String post(String url, String json) {
//        RequestBody requestBody = RequestBody.create(JSON, json);
//        Request request = new Request.Builder().url(url).post(requestBody).build();
//        try {
//            Response response = okHttpClient.newCall(request).execute();
//            return response.body().string();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }

}
