package com.sreeyainfotech.retrofitexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sreeyainfotech.retrofitexample.model.Allcategorieslist;

public class Main2Activity extends AppCompatActivity {

    Allcategorieslist allcategorieslist;
    private TextView text;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i=getIntent();
        if(i!=null){
            string =i.getStringExtra("Model");
        }
        text=(TextView)findViewById(R.id.text);
        text.setText(string);

//        Intent i=getIntent();
//        if(i!=null) {
//            allcategorieslist = (Allcategorieslist)i.getSerializableExtra("Model");
//
//            text = (TextView) findViewById(R.id.text);
//            text.setText(allcategorieslist.getCategory_name());
//        }

    }
}
