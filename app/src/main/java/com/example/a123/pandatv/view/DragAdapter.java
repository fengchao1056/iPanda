package com.example.a123.pandatv.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a123.pandatv.R;

import java.util.List;


public class DragAdapter extends BaseAdapter {
    private Context context;
    public List<String> channels;

    public DragAdapter(Activity activity, List<String> channels) {
        context = activity;
        this.channels = channels;
    }

    @Override
    public int getCount() {
        return channels.size();
    }

    @Override
    public Object getItem(int position) {
        return channels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.category_item, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.text_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(channels.get(position));
        return convertView;
    }

    public void swap(int i, int j) {
        if (j < i) {
            String s = channels.get(i);
            channels.add(j, s);
            channels.remove(i + 1);
        } else if (i < j) {
            String s = channels.get(i);
            channels.add(j + 1, s);
            channels.remove(i);
        }
    }

    static class ViewHolder {
        public TextView textView;
    }
}
