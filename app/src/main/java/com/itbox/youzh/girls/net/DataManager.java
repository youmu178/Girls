package com.itbox.youzh.girls.net;

/**
 * Created by youzh on 2014/12/28.
 */
public class DataManager {
    public static volatile DataManager dataManager = null;

    private DataManager() {
    }

    public static DataManager getInstance() {
        if (dataManager == null) {
            synchronized (DataManager.class) {
                if (dataManager == null) {
                    dataManager = new DataManager();
                }
            }
        }
        return dataManager;
    }

    public void getData(int way) {
        DataNetThread dataNetThread = new DataNetThread(way);
        dataNetThread.setPriority(Thread.NORM_PRIORITY - 1);
        dataNetThread.start();
    }
}
