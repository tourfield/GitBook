package com.github.tourfield.gitbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button gotoSelfBt;
    private Button gotSignInBt;
    private Intent gotoIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: @ "+ this.toString());
        setContentView(R.layout.layout_main);
        gotoSelfBt=(Button)findViewById(R.id.gotoSelf);
        gotSignInBt=(Button)findViewById(R.id.gotoSignIn);

        gotoSelfBt.setOnClickListener(this);
        gotSignInBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gotoSelf:
                gotoIntent = new Intent(this,MainActivity.class);
                startActivity(gotoIntent);
                break;
            case R.id.gotoSignIn:
                gotoIntent = new Intent(this,SignInActivity.class);
                startActivity(gotoIntent);
                break;
        }

    }
}
