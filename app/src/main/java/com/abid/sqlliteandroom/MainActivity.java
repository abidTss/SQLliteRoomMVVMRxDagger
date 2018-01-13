package com.abid.sqlliteandroom;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tvGetData)
    Button btn;
    @BindView(R.id.button)
    Button btnHitApi;
  /*  @Inject
    DbHelper dbHelper;*/
   /*  @Inject
    Retrofit retrofit;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       // ((AppClass) getApplication()).getDBComponent().inject(this);
        //   ((AppClass) getApplication()).getNetComponent().inject(this);
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eId", 1);
        contentValues.put("eName", "Abid khan");
        contentValues.put("eDesignation", "Android developer");
        sqLiteDatabase.insert("Employee", null, contentValues);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("is clicked", "yes im here");
                getSqlite();
            }
        });
        btnHitApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityTwo.class));
            }
        });
    }

    void getSqlite() {
        String[] columns = {"eId", "eName", "eDesignation"};
        Log.e("is clicked", "yes im here");
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("Employee", columns, null, null, null, null, null);
        System.out.println(cursor.getCount() + " --");
        System.out.println(cursor.moveToFirst() + " ---");
        cursor.moveToFirst();

        System.out.println(cursor.getString(1));
        /*
        while (cursor.moveToNext()){
            System.out.println(cursor.getColumnName(cursor.getPosition()));
        }*/
    }
}
