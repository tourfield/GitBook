package com.github.tourfield.gitbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WebActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SignInActivity";
    private static final int intentFd = 20001;
    private EditText editText;
    private Button webOkBt;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_web);
        editText = (EditText)findViewById(R.id.webEditTxt);
        webOkBt = (Button) findViewById(R.id.webOkBt);
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
                finish();
                break;
        }
    }
}
