package com.itbox.youzh.girls.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.itbox.youzh.girls.R;
import com.jpardogo.listbuddies.lib.adapters.CircularLoopAdapter;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by youzh on 2014/12/23.
 */
public class ListBuddiesAdapter extends CircularLoopAdapter {

    private List<String> mItemUrl = new ArrayList<String>();

    private Context mContext;
    private int mRowHeight;
    private DisplayImageOptions options;
    private LayoutInflater inflater;

    public ListBuddiesAdapter(Context ctx, int rowHeight, List<String> mItems, DisplayImageOptions options) {
        this.mContext = ctx;
        this.mItemUrl = mItems;
        this.options = options;
        this.mRowHeight = rowHeight;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    protected int getCircularCount() {
        return mItemUrl.size();
    }

    @Override
    public String getItem(int position) {
        return mItemUrl.get(getCircularPosition(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_item_listbuddies, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//        holder.mImage.setMinimumHeight(mRowHeight);
        String itemUrl = getItem(position);
        ImageLoader.getInstance().displayImage(itemUrl, holder.mImage, options);
//        Picasso.with(mContext).load(itemUrl).into(holder.mImage);
        return convertView;
    }


    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'layout_item_listbuddies.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Inmite Developers (http://inmite.github.io)
     */
    static class ViewHolder {
        @InjectView(R.id.image)
        ImageView mImage;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
