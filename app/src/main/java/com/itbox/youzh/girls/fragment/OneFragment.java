package com.itbox.youzh.girls.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;
import com.itbox.youzh.girls.R;
import com.itbox.youzh.girls.adapter.GridAdapter;
import com.itbox.youzh.girls.common.ImagesUrls;
import com.itbox.youzh.girls.net.DataManager;
import com.itbox.youzh.girls.view.DragScrollListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;

/**
 * 美女图片
 */
public class OneFragment extends BaseFragment {

    @InjectView(R.id.grid_view)
    StaggeredGridView mGridView;
    private GridAdapter gridAdapter;
    private List<String> mImagesUrls = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.activity_grid_main, null);
        ButterKnife.inject(this, layout);
        mImagesUrls.addAll(Arrays.asList(ImagesUrls.imageUrls_all));
        gridAdapter = new GridAdapter(mAct, mImagesUrls, options);
        mGridView.setAdapter(gridAdapter);
        mGridView.setOnItemClickListener(this);

//        DataManager dataManager = DataManager.getInstance();
//        dataManager.getData();
        mGridView.setOnScrollListener(new DragScrollListener(mGridView));
        return layout;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        super.onItemClick(parent, view, position, id);
        Toast.makeText(mAct, position+"", Toast.LENGTH_SHORT).show();
    }
}
