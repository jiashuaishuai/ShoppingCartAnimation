package com.example.jiashuai.myapplicationbeisaier.myadapter;

import android.content.Context;
import android.graphics.Path;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiashuai.myapplicationbeisaier.R;

import java.util.List;

/**
 * Created by JiaShuai on 2017/5/9.
 */

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mData;
    private LayoutInflater inflater;
    private int[] p;

    public MyListAdapter(Context context, List<String> stringList,int [] p) {
        mContext = context;
        mData = stringList;
        this.p = p;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item, parent, false);
            viewHolder.icon_img = (ImageView) convertView.findViewById(R.id.icon_img);
            viewHolder.name_tv = (TextView) convertView.findViewById(R.id.name_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name_tv.setText(mData.get(position));
        return convertView;
    }

    public class ViewHolder {
        TextView name_tv;
        ImageView icon_img;
    }

}
