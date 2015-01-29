package com.itbox.youzh.girls.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.itbox.youzh.girls.R;
import com.itbox.youzh.girls.bean.PageInfo;
import com.itbox.youzh.girls.fragment.FiveFragment;
import com.itbox.youzh.girls.fragment.FourFragment;
import com.itbox.youzh.girls.fragment.OneFragment;
import com.itbox.youzh.girls.fragment.SixFragment;
import com.itbox.youzh.girls.fragment.ThreeFragment;
import com.itbox.youzh.girls.fragment.TwoFragment;
import com.itbox.youzh.girls.view.PagerSlidingTabStrip;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.lightsky.infiniteindicator.InfiniteIndicatorLayout;
import cn.lightsky.infiniteindicator.slideview.BaseSliderView;
import cn.lightsky.infiniteindicator.slideview.DefaultSliderView;
import de.greenrobot.event.EventBus;
import github.chenupt.dragtoplayout.DragTopLayout;

/**
 * Created by youzh on 2015/1/25.
 */
public class MainActivity extends ActionBarActivity implements BaseSliderView.OnSliderClickListener{

    @InjectView(R.id.pagerTabStrip)
    PagerSlidingTabStrip mPagerTabStrip;
    @InjectView(R.id.viewPager)
    ViewPager mViewPager;
    @InjectView(R.id.tool_bar)
    Toolbar mToolBar;
    @InjectView(R.id.top_view)
    LinearLayout mTopView;
    @InjectView(R.id.drag_content_view)
    LinearLayout mDragContentView;
    @InjectView(R.id.drag_layout)
    DragTopLayout mDragLayout;
    @InjectView(R.id.infinite_anim_line)
    cn.lightsky.infiniteindicator.InfiniteIndicatorLayout mInfiniteAnimLine;
    private ArrayList<Fragment> mFragmentList = new ArrayList<Fragment>();
    private ArrayList<PageInfo> viewInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mToolBar.setTitle("Girls");
        setSupportActionBar(mToolBar);
        DragTopLayout.from(this).open().setRefreshRadio(1.4f).setOverDrag(false).listener(new DragTopLayout.SimplePanelListener() {
            @Override
            public void onPanelStateChanged(DragTopLayout.PanelState panelState) {
                super.onPanelStateChanged(panelState);
            }

            @Override
            public void onSliding(float radio) {
                super.onSliding(radio);
            }

            @Override
            public void onRefresh() {
                super.onRefresh();
            }
        }).setup(mDragLayout);

        viewInfos = new ArrayList<PageInfo>();
        viewInfos.add(new PageInfo("Page A", R.drawable.a));
        viewInfos.add(new PageInfo("Page B", R.drawable.b));
        testAnimLineIndicator();

        mFragmentList.add(new OneFragment());
        mFragmentList.add(new TwoFragment());
        mFragmentList.add(new ThreeFragment());
        mFragmentList.add(new FourFragment());
        mFragmentList.add(new FiveFragment());
        mFragmentList.add(new SixFragment());
        mViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), mFragmentList));
        mPagerTabStrip.setViewPager(mViewPager);
    }
    private void testAnimLineIndicator() {
        for(PageInfo name : viewInfos){
            DefaultSliderView textSliderView = new DefaultSliderView(this);
            textSliderView
                    .image(name.getDrawableRes())
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.getBundle()
                    .putString("extra", name.getData());
            mInfiniteAnimLine.addSlider(textSliderView);
        }
        mInfiniteAnimLine.setIndicatorPosition(InfiniteIndicatorLayout.IndicatorPosition.Center);
    }

    public void onEvent(Boolean intercept) {
        mDragLayout.setTouchMode(intercept);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
        mInfiniteAnimLine.startAutoScroll();
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
        mInfiniteAnimLine.stopAutoScroll();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.action_settings:
                break;
            case R.id.action_share:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    public class PagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> fragmentsList;
        private final String[] TITLES = {"美女图片", "美女写真", "丝袜美女", "明星模特", "日韩美女", "动漫图片"};

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public PagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentsList) {
            super(fm);
            this.fragmentsList = fragmentsList;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public Fragment getItem(int arg0) {
            return fragmentsList.get(arg0);
        }

        @Override
        public int getCount() {
            return fragmentsList.size();
        }

    }
}
