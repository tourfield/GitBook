package com.github.tourfield.gitbook;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button gotoSelfBt;
    private Button gotSignInBt;
    private Intent gotoIntent;
    private ImageView imageView;
    private ProgressBar progressBar01;
    private ProgressBar progressBar02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: @ "+ this.toString());
        setContentView(R.layout.layout_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.hide();
        }
        gotoSelfBt=(Button)findViewById(R.id.gotoSelf);
        gotSignInBt=(Button)findViewById(R.id.gotoSignIn);
        imageView = (ImageView)findViewById(R.id.draginCatImg);
        progressBar01 = (ProgressBar)findViewById(R.id.progressBar01);
        progressBar02 = (ProgressBar)findViewById(R.id.progressBar02);
        gotoSelfBt.setOnClickListener(this);
        gotSignInBt.setOnClickListener(this);
        imageView.setOnClickListener(this);
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

            case R.id.draginCatImg:
//                Toast.makeText(this,"show",Toast.LENGTH_SHORT).show();
//                imageView.setImageResource(R.drawable.flowers);
//                if(imageView.getVisibility()==View.VISIBLE)
//                    imageView.setVisibility(View.GONE);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Show Dialog");
                dialog.setMessage("ARE YOU Sure to disable progress Bar!");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                ProgressDialog.Builder progressDialog = new ProgressDialog.Builder(MainActivity.this);
                progressDialog.setTitle("loading");
                progressDialog.setMessage("loading ...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                if(progressBar01.getVisibility() == View.GONE){
                    progressBar01.setVisibility(View.VISIBLE);
                }else{
                    progressBar01.setVisibility(View.GONE);
                }
                int progress=progressBar02.getProgress();
                progress = progress+10;
                progressBar02.setProgress(progress);
                break;
        }

    }
}
