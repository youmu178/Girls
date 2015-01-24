package com.itbox.youzh.girls.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;
import com.itbox.youzh.girls.R;
import com.itbox.youzh.girls.adapter.GridAdapter;
import com.itbox.youzh.girls.common.ImagesUrls;
import com.itbox.youzh.girls.net.DataManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by youzh on 2014/12/24.
 */
public class MainGridActivity extends BaseActivity implements AdapterView.OnItemClickListener{

    @InjectView(R.id.grid_view)
    StaggeredGridView mGridView;
    private GridAdapter gridAdapter;
    private List<String> mImagesUrls = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_main);
        ButterKnife.inject(this);
        mImagesUrls.addAll(Arrays.asList(ImagesUrls.imageUrls_all));
        gridAdapter = new GridAdapter(mAct, mImagesUrls, options);
        mGridView.setAdapter(gridAdapter);
        mGridView.setOnItemClickListener(this);

        DataManager dataManager = DataManager.getInstance();
        dataManager.getData();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mAct, ""+position, Toast.LENGTH_SHORT).show();
    }
}
