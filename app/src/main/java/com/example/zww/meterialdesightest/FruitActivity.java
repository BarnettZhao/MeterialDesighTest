package com.example.zww.meterialdesightest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by zww on 2017/8/3.
 */

public class FruitActivity extends AppCompatActivity {
    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_IMAGE_ID = "fruit_image_id";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        Intent intent = getIntent();
        String name = intent.getStringExtra(FRUIT_NAME);
        int imageId = intent.getIntExtra(FRUIT_IMAGE_ID,0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.fruit_detail_toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.fruit_detail_collaspsing_toolbar);
        ImageView imageView = (ImageView) findViewById(R.id.fruit_detail_img);
        TextView textView = (TextView) findViewById(R.id.fruit_detail_text);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(name);
        Glide.with(this).load(imageId).into(imageView);
        String fruitContent = "";
        for (int i = 0; i < 500; i++) {
            fruitContent += name;
        }
        textView.setText(fruitContent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
