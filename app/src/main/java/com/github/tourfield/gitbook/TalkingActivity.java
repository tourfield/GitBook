package com.github.tourfield.gitbook;

import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TalkingActivity extends AppCompatActivity implements View.OnClickListener {
    private List <Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talking);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.hide();
        }
        TextView titleText = (TextView)findViewById(R.id.titleEditTxt);
        titleText.setText("Lover");
        initMsg();
        inputText =(EditText)findViewById(R.id.inputMsg);
        send =(Button)findViewById(R.id.sendMsgBt);
        msgRecyclerView = (RecyclerView)findViewById(R.id.msgRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(this);
    }

    private void initMsg() {
        Msg msg1=new Msg("Where R U, I miss U!",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2=new Msg("I am here, I want U!",Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3=new Msg("Why R U so later, Didn't U know I'm wanting for U too long time !",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }

    @Override
    public void onClick(View v) {
        String content = inputText.getText().toString();
        if (!"".equals(content)){
            Msg msg =  new Msg(content,Msg.TYPE_SEND);
            msgList.add(msg);
            adapter.notifyItemInserted(msgList.size() - 1);
            msgRecyclerView.scrollToPosition(msgList.size() - 1);
            inputText.setText("");
        }
    }
}
