package com.github.tourfield.gitbook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Geary on 2017/6/2.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Msg> mMsgList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        public  ViewHolder(View view){
            super(view);
            leftLayout=(LinearLayout)view.findViewById(R.id.left_layout);
            rightLayout=(LinearLayout)view.findViewById(R.id.right_layout);
            leftMsg = (TextView)view.findViewById(R.id.comeInMsg);
            rightMsg = (TextView)view.findViewById(R.id.sendToMsg);
        }
    }
    public MsgAdapter(List<Msg> msgList){
        mMsgList = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_msg,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED){
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContext());
        }else if (msg.getType() == Msg.TYPE_SEND){
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getContext());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }
}
