package com.itbox.youzh.girls.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.itbox.youzh.girls.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by youzh on 2014/12/24.
 */
public class GridAdapter extends BaseAdapter {
    private List<String> mItemsUrl;
    private DisplayImageOptions options;
    private LayoutInflater inflater;

    public GridAdapter(Context context, List<String> mItems, DisplayImageOptions options) {
        this.mItemsUrl = mItems;
        this.options = options;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mItemsUrl.size();
    }

    @Override
    public String getItem(int position) {
        return mItemsUrl.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_item_grid, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(getItem(position), holder.mItemIv, options);
        return convertView;
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'layout_item_grid.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Inmite Developers (http://inmite.github.io)
     */
    static class ViewHolder {
        @InjectView(R.id.item_iv)
        ImageView mItemIv;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
