package com.itbox.youzh.girls.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.itbox.youzh.girls.R;
import com.itbox.youzh.girls.adapter.ListBuddiesAdapter;
import com.itbox.youzh.girls.common.ImagesUrls;
import com.jpardogo.listbuddies.lib.views.ListBuddiesLayout;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ListBuddiesActivity extends BaseActivity implements ListBuddiesLayout.OnBuddyItemClickListener {

    @InjectView(R.id.listbuddies)
    ListBuddiesLayout mListbuddies;

    private List<String> mImagesLeftUrl = new ArrayList<String>();
    private List<String> mImagesRightUrl = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listbuddies);
        ButterKnife.inject(this);
        mImagesLeftUrl.addAll(Arrays.asList(ImagesUrls.imageUrls_left));
        mImagesRightUrl.addAll(Arrays.asList(ImagesUrls.imageUrls_right));
        ListBuddiesAdapter mLeftAdapter = new ListBuddiesAdapter(mAct, getResources().getDimensionPixelSize(R.dimen.item_height_small), mImagesLeftUrl, options);
        ListBuddiesAdapter mRightAdapter = new ListBuddiesAdapter(mAct, getResources().getDimensionPixelSize(R.dimen.item_height_tall), mImagesRightUrl, options);
        mListbuddies.setAdapters(mLeftAdapter, mRightAdapter);
        mListbuddies.setOnItemClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBuddyItemClicked(AdapterView<?> adapterView, View view, int buddy, int position, long l) {

        Log.d("youzh", buddy + " ----- " + position);
    }
}
