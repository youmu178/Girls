package com.itbox.youzh.girls.net;

import android.util.Log;

import com.itbox.youzh.girls.common.Common;
import com.itbox.youzh.girls.common.WebDefine;
import com.itbox.youzh.girls.util.JsoupData;

/**
 * Created by youzh on 2014/12/28.
 */
public class DataNetThread extends Thread {
    private int switchWay;

    public DataNetThread(int way) {
        switchWay = way;
    }

    @Override
    public void run() {
        super.run();
        switch (switchWay) {
            case Common.MAIN_DATA:
                String data = Net.get(WebDefine.BASEURL);
                Log.i("youzh", "获取的数据是： " + data);
                JsoupData.getUrl(data);
                break;
        }
    }
}
