package com.github.tourfield.gitbook;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "main Activity";
    private Button signInBt;
    private EditText userName;
    private EditText passWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        signInBt = (Button)findViewById(R.id.signInBt);
        userName = (EditText)findViewById(R.id.userName);
        passWord = (EditText)findViewById(R.id.passWord);
        signInBt.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.signInItem:
                Log.i(TAG, "onOptionsItemSelected: sign In Item");
                break;
            case R.id.signUpItem:
                Log.i(TAG, "onOptionsItemSelected: sign Up Item");
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signInBt:
                Log.i(TAG, "onClick: signInBt");
                Toast.makeText(this,"user name: "+ userName.getText().toString()+" pass word: "+ passWord.getText().toString(),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
