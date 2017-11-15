package com.github.tourfield.gitbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.tourfield.gitbook.base.BaseActivity;

public class WebActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "SignInActivity";
    private static final int intentFd = 20001;
    private EditText editText;
    private Button webOkBt;
    private Button gotoSelfBt;
    private Button gotoMainBt;
    private Intent gotoIntent;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: @ "+ this.toString());
        setContentView(R.layout.layout_web);
        editText = (EditText)findViewById(R.id.webEditTxt);
        webOkBt = (Button) findViewById(R.id.webOkBt);
        gotoSelfBt=(Button)findViewById(R.id.gotoSelf);
        gotoMainBt=(Button)findViewById(R.id.gotoMain);

        gotoSelfBt.setOnClickListener(this);
        gotoMainBt.setOnClickListener(this);
        intent = getIntent();
        String weiBoData = intent.getStringExtra("weiBoData");
        editText.setText(weiBoData);
        webOkBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.webOkBt:
                Log.i(TAG, "onClick: webOkBt");
                intent.putExtra("retrunResult",editText.getText().toString());
                setResult(RESULT_OK,intent);
//                finish();
                break;
            case R.id.gotoSelf:
                gotoIntent = new Intent(this,WebActivity.class);
                startActivity(gotoIntent);
                break;
            case R.id.gotoMain:
                gotoIntent = new Intent(this,MainActivity.class);
                startActivity(gotoIntent);
                break;
        }
    }
}
