package com.itbox.youzh.girls.net;

import android.util.Log;

import com.itbox.youzh.girls.util.JsoupData;

/**
 * Created by youzh on 2014/12/28.
 */
public class DataNetThread extends Thread {

    public DataNetThread() {
    }

    @Override
    public void run() {
        super.run();
        String data = Net.get("http://www.ny369.com/");
        Log.i("youzh", "获取的数据是： " + data);
        JsoupData.getUrl(data);
    }
}
