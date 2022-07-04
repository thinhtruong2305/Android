package com.example.gridviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class HinhAnhAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<HinhAnhPandoru> arrayHinhAnh;

    public HinhAnhAdapter(Context context, int layout, ArrayList<com.example.gridviewnangcao.HinhAnhPandoru> arrayHinhAnh) {
        this.context = context;
        this.layout = layout;
        this.arrayHinhAnh = arrayHinhAnh;
    }

    @Override
    public int getCount() {
        return arrayHinhAnh.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgHinhAnh;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.imgHinhAnh = convertView.findViewById(R.id.imageViewHinhAnh);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        HinhAnhPandoru hinhAnhPandoru = arrayHinhAnh.get(position);
        holder.imgHinhAnh.setImageResource(hinhAnhPandoru.getHinh());

        return convertView;
    }
}
