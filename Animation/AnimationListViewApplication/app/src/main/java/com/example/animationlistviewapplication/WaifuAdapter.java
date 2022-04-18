package com.example.animationlistviewapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WaifuAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Waifu> waifuList;

    public WaifuAdapter() {
    }

    public WaifuAdapter(Context context, int layout, List<Waifu> waifuList) {
        this.context = context;
        this.layout = layout;
        this.waifuList = waifuList;
    }

    @Override
    public int getCount() { return waifuList.size(); }

    @Override
    public Object getItem(int position) { return null; }

    @Override
    public long getItemId(int position) { return 0; }

    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen, txtMoTa;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder = new ViewHolder();
            //ánh xạ
            holder.txtTen = convertView.findViewById(R.id.textViewTen);
            holder.txtMoTa = convertView.findViewById(R.id.textViewMoTa);
            holder.imgHinh = convertView.findViewById(R.id.imageViewHinh);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //gán giá trị
        Waifu waifu = waifuList.get(position);

        holder.txtTen.setText(waifu.getTen());
        holder.txtMoTa.setText(waifu.getMoTa());
        holder.imgHinh.setImageResource(waifu.getHinh());

        //gán animation
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_listview);
        convertView.startAnimation(animation);

        return convertView;
    }
}
