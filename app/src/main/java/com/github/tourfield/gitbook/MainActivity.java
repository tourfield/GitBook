package com.github.tourfield.gitbook;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.github.tourfield.gitbook.base.ActivityCollector;
import com.github.tourfield.gitbook.base.BaseActivity;
import com.github.tourfield.gitbook.fruit.Fruit;
import com.github.tourfield.gitbook.fruit.FruitAdapter;
import com.github.tourfield.gitbook.fruit.FruitRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button gotoSelfBt;
    private Button gotSignInBt;
    private Intent gotoIntent;
    private ImageView imageView;
    private ProgressBar progressBar01;
    private ProgressBar progressBar02;
    /**
     * ListView 实现
     * private ListView listView;
     */

    private String[] fruitNmaes={"peach桃子",
            "Lemon 柠檬",
            "Pear 梨子" ,
            "avocado南美梨" ,
            "cantaloupe美国香瓜" ,
            "Banana 香蕉" ,
            "Grape 葡萄" ,
            "raisins葡萄干" ,
            "plum 李子" ,
            "apricot杏子",
            "nectarine油桃" ,
            "honeydew(melon)哈密瓜",
            "orange 橙子",
            "tangerine 橘子",
            "guava番石榴",
            "Golden apple 黄绿苹果、脆甜",
            "Granny smith 绿苹果",
            "papaya木瓜",
            "Bramley绿苹果",
            "Mclntosh麦金托什红苹果",
            "coconut椰子 ",
            "jack fruit 菠萝蜜、大树菠萝 ",
            "prunes干梅子 ",
            "blueberry 乌饭果 ",
            "cranberry酸莓 ",
            "raspberry山霉 ",
            "Mango 芒果 ",
            "fig 无花果 ",
            "pineapple 菠萝 ",
            "Kiwi 奇异果（弥猴桃） ",
            "Star fruit 杨桃 ",
            "Cherry 樱桃 ",
            "watermelon西瓜" ,
            "pumelo 柚子 ",
            "lime 酸橙 ",
            "Dates 枣子 ",
            "lychee 荔枝 ",
            "Grape fruit 葡萄柚 ",
            "Coconut 椰子 ",
            "Fig 无花果 ",
            "Durin 榴梿 ",
            "Loquat 枇杷 ",
            "Pitaya 火龙果",
            "strawberry草莓",
            "orange橘子",
            "Kumquat金桔",
            "Raspberry覆盆子"
    };
    private List<Fruit> fruitList = new ArrayList<>();
    private static final int SPANLINENUMBER = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: @ "+ this.toString());
        setContentView(R.layout.layout_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        initFruit();
//        ArrayAdapter <String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,data);
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this,R.layout.fruit_iterm,fruitList);
        gotoSelfBt=(Button)findViewById(R.id.gotoSelf);
        /**
         *  ListView 实现
         * listView=(ListView)findViewById(R.id.listView);
         * listView.setAdapter(fruitAdapter);
         * listView.setOnItemClickListener(this);
         */


        gotSignInBt=(Button)findViewById(R.id.gotoSignIn);
        imageView = (ImageView)findViewById(R.id.draginCatImg);
        progressBar01 = (ProgressBar)findViewById(R.id.progressBar01);
        progressBar02 = (ProgressBar)findViewById(R.id.progressBar02);
        gotoSelfBt.setOnClickListener(this);
        gotSignInBt.setOnClickListener(this);
        imageView.setOnClickListener(this);


        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(SPANLINENUMBER,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitRecyclerAdapter fruitRecyclerAdapter = new FruitRecyclerAdapter(fruitList);
        recyclerView.setAdapter(fruitRecyclerAdapter);
        recyclerView.setOnClickListener(this);
    }

    private void initFruit() {
        for (String fruitName:fruitNmaes){
            Fruit fruit = new Fruit(getRandomLengthName(fruitName),R.drawable.cm);
            fruitList.add(fruit);
        }
    }

    private String getRandomLengthName(String fruitName) {
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(fruitName);
        }
        return builder.toString();
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
                if(imageView.getVisibility()==View.VISIBLE)
                    imageView.setVisibility(View.GONE);
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

    /**
     *  ListView 实现
     *
     * @Override
     *  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
     *   Fruit fruit=fruitList.get(position);
     *  Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
     *   }
     */
}
