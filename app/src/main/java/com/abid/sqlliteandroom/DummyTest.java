package com.abid.sqlliteandroom;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.abid.sqlliteandroom.databinding.ActivityRoomDatabaseBinding;

/**
 * Created by abid on 13/1/18.
 */

public class DummyTest extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // ActivityRoomDatabaseBinding dummyTestBinding= DataBindingUtil.setContentView(this,R.layout.activity_room_database);
    }
}
