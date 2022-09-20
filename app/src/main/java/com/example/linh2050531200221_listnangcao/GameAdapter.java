package com.example.linh2050531200221_listnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GameAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Game> gameList;

    public GameAdapter(Context context, int layout, List<Game> gameList) {
        this.context = context;
        this.layout = layout;
        this.gameList = gameList;
    }

    @Override
    public int getCount() {
        return gameList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public class ViewHolder{
        ImageView imgHinh;
        TextView tTen,tMoTa,tGia;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if (view==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout, null);
            holder=new ViewHolder();
            holder.tTen=(TextView) view.findViewById(R.id.textviewTen);
            holder.tMoTa=(TextView) view.findViewById(R.id.textviewMoTa);
            holder.tGia=(TextView) view.findViewById(R.id.textviewGia);
            holder.imgHinh=(ImageView) view.findViewById(R.id.imageviewHinh);
            view.setTag(holder);

        }else {
            holder= (ViewHolder) view.getTag();
        }

        Game game= gameList.get(i);

        holder.tTen.setText(game.getTen());
        holder.tMoTa.setText(game.getMoTa());
        holder.tGia.setText(game.getGia());
        holder.imgHinh.setImageResource(game.getHinh());

        return view;
    }

}
