package com.github.tourfield.gitbook;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
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

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SignInActivity";
    private static final int intentFd = 20001;
    private Button signInBt;
    private Button gotoSelfBt;
    private Button gotSignUpBt;
    private Intent gotoIntent;
    private EditText userName;
    private String strName;
    private EditText passWord;
    private Intent intent;
//    private final static String strUrl="https://www.gitbook.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: @ "+ this.toString());
        setContentView(R.layout.layout_signin);
        if (savedInstanceState != null){
            strName = savedInstanceState.getString("data_key");
            Log.d(TAG, "onCreate: " + strName);
            Toast.makeText(this,strName,Toast.LENGTH_SHORT).show();
        }
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        signInBt = (Button)findViewById(R.id.signInBt);
        userName = (EditText)findViewById(R.id.userName);
        passWord = (EditText)findViewById(R.id.passWord);
        gotoSelfBt=(Button)findViewById(R.id.gotoSelf);
        gotSignUpBt=(Button)findViewById(R.id.gotoSignUp);

        gotoSelfBt.setOnClickListener(this);
        gotSignUpBt.setOnClickListener(this);
        signInBt.setOnClickListener(this);
        if(strName != null){
            userName.setText(strName);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        String tempData = "save string";
        outState.putString("data_key",strName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_signin,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.signInItem:
                Log.i(TAG, "onOptionsItemSelected: sign In Item");
                break;
            case R.id.signUpItem:
                /**
                 * Intent 显式调用
                 */
                Log.i(TAG, "onOptionsItemSelected: sign Up Item");
                intent = new Intent(this,SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.othersSignInItem:
                Log.i(TAG, "onOptionsItemSelected: others sign In Item");
                /**
                 * Intent隐式调用
                 */
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.weiBoSignInItem:
                Log.i(TAG, "onOptionsItemSelected:wei bo sign In Item");
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                intent.putExtra("weiBoData","123456");
//                startActivity(intent);
                startActivityForResult(intent,intentFd);
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case intentFd:
                if (resultCode == RESULT_OK){
                    Log.i(TAG, "onActivityResult: ");
                    userName.setText(data.getStringExtra("retrunResult"));
                }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signInBt:
                Log.i(TAG, "onClick: signInBt");
                strName = userName.getText().toString();
                Toast.makeText(this,"user name: "+ strName +" pass word: "+ passWord.getText().toString(),Toast.LENGTH_SHORT).show();
                /**
                 * Intent隐式调用
                 */
                intent = new Intent("com.github.tourfield.gitbook.ACTION_START");
                intent.addCategory("com.github.tourfield.gitbook.MYCATEGORY");
                startActivity(intent);
                break;
            case R.id.gotoSelf:
                gotoIntent = new Intent(this,SignInActivity.class);
                startActivity(gotoIntent);
                break;
            case R.id.gotoSignUp:
                gotoIntent = new Intent(this,SignUpActivity.class);
                startActivity(gotoIntent);
                break;
        }
    }
}
