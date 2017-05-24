package com.github.tourfield.gitbook;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Geary on 2017/5/24.
 */

public class TitleLayout extends LinearLayout implements View.OnClickListener {
    private Button titleBackBt;
    private Button titleEditBt;
    public TitleLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        titleBackBt = (Button)findViewById(R.id.titleBackBt);
        titleEditBt = (Button)findViewById(R.id.titleEditBt);
        titleBackBt.setOnClickListener(this);
        titleEditBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.titleBackBt:
                Toast.makeText(getContext(),"titleBackBt",Toast.LENGTH_SHORT).show();
                break;
            case R.id.titleEditBt:
                Toast.makeText(getContext(),"titleEditBt",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
