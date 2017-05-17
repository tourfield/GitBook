package com.github.tourfield.gitbook;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SignUpActivity";
    private Intent intent;
    private Button signUpBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);
        signUpBt=(Button)findViewById(R.id.signUpBt);
        signUpBt.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_signup,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.telItem:
                Log.i(TAG, "onOptionsItemSelected: ");
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"));
                startActivity(intent);
                break;
            case R.id.faceBookItem:
                Log.i(TAG, "onOptionsItemSelected: ");
                break;
            default:
                Log.e(TAG, "onOptionsItemSelected: ");
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signUpBt:
                Log.i(TAG, "onClick: signUpBt");
                break;
        }
    }
}
