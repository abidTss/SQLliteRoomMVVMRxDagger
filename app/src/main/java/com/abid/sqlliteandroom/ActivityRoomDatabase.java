package com.abid.sqlliteandroom;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.abid.sqlliteandroom.databinding.ActivityRoomDatabaseBinding;
import com.abid.sqlliteandroom.roomdb.AppDataBase;
import com.abid.sqlliteandroom.roomdb.DatabaseInitializer;

/**
 * Created by abid on 8/1/18.
 */

public class ActivityRoomDatabase extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRoomDatabaseBinding activityRoomDatabaseBinding=
                DataBindingUtil.setContentView(this,R.layout.activity_room_database);

        activityRoomDatabaseBinding.clickHereBtn.setOnClickListener(
                View-> DatabaseInitializer.populateAsync(AppDataBase.getAppDatabase(this))
        );

        activityRoomDatabaseBinding.viewInsertedData.setOnClickListener(
                View ->DatabaseInitializer.getEmpList(AppDataBase.getAppDatabase(this))
        );
    }

    @Override
    protected void onDestroy() {
        AppDataBase.destroyInstance();
        super.onDestroy();
    }
}
