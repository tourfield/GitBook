package com.github.tourfield.gitbook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Geary on 2017/5/24.
 */

public class FruitAdapter extends ArrayAdapter {
    private int resourceId;
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit>obj){
        super(context,textViewResourceId,obj);
        resourceId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = (Fruit)getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView)view.findViewById(R.id.fruitImage);
            viewHolder.fruitName=(TextView)view.findViewById(R.id.fruitName);
            view.setTag(viewHolder);
        }
        else {
            view = convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
//        ImageView fruitImage = (ImageView)view.findViewById(R.id.fruitImage);
//        TextView fruitView = (TextView)view.findViewById(R.id.fruitName);
//        fruitImage.setImageResource(fruit.getImageId());
//        fruitView.setText(fruit.getName());
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }
}
