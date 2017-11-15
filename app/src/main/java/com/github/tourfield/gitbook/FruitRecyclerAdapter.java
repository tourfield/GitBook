package com.github.tourfield.gitbook;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Geary on 2017/5/24.
 */

public class FruitRecyclerAdapter extends RecyclerView.Adapter<FruitRecyclerAdapter.ViewHolder> implements View.OnClickListener {
    private static final String TAG = "FruitRecyclerAdapter";
    private List<Fruit> mFruitList;
    private ViewHolder holder;

    @Override
    public void onClick(View v) {
        int position = holder.getAdapterPosition();
        Fruit fruit = mFruitList.get(position);
        switch (v.getId()){
        case R.id.fruitImage:
            Toast.makeText(v.getContext(), "fruitImage" + fruit.getName(), Toast.LENGTH_SHORT).show();
            break;
            case R.id.fruitName:
                Toast.makeText(v.getContext(), "fruitName" + fruit.getName(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
        public ViewHolder(View view){
            super(view);
            Log.d(TAG, "ViewHolder: @ "+ this.toString());
            fruitImage=(ImageView)view.findViewById(R.id.fruitImage);
            fruitName = (TextView)view.findViewById(R.id.fruitName);
        }
    }
    public FruitRecyclerAdapter(List<Fruit> fruitList){
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: @ "+ this.toString());
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_iterm,parent,false);
        Log.d(TAG, "before call : ViewHolder");
        holder= new ViewHolder(view);
        Log.d(TAG, "after call : ViewHolder");
        holder.fruitImage.setOnClickListener(this);
        holder.fruitName.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: @ "+ position);
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: @ "+ mFruitList.size());
        return mFruitList.size();
    }
}
