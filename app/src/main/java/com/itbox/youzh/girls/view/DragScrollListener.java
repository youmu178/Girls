package com.itbox.youzh.girls.view;

import android.widget.AbsListView;
import android.widget.GridView;

import de.greenrobot.event.EventBus;

/**
 * Created by youzh on 2015/1/28.
 */
public class DragScrollListener implements AbsListView.OnScrollListener {

    private AbsListView mGridView;
    public DragScrollListener(android.widget.AbsListView gridView) {
        this.mGridView = gridView;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (mGridView.getChildCount() > 0) {
            if (mGridView.getChildAt(0).getTop() >= 0) {
                EventBus.getDefault().post(true);
            } else {
                EventBus.getDefault().post(false);
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (mGridView.getChildCount() > 0) {
            if (mGridView.getChildAt(0).getTop() >= 0) {
                EventBus.getDefault().post(true);
            } else {
                EventBus.getDefault().post(false);
            }
        }
    }
}
