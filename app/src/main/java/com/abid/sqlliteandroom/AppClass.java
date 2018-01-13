package com.abid.sqlliteandroom;

import android.app.Application;

import com.abid.sqlliteandroom.di.component.DBComponent;


import com.abid.sqlliteandroom.di.component.DaggerDBComponent;
import com.abid.sqlliteandroom.di.component.DaggerNetComponent;
import com.abid.sqlliteandroom.di.component.NetComponent;
import com.abid.sqlliteandroom.di.module.AppModule;
import com.abid.sqlliteandroom.di.module.DBModule;
import com.abid.sqlliteandroom.di.module.NetModule;

/**
 * Created by abid on 4/1/18.
 */

public class AppClass extends Application {
    private DBComponent component;
    private NetComponent netComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        component= DaggerDBComponent.builder()
                .appModule(new AppModule(this))
                .dBModule(new DBModule())
                .build();

        netComponent= DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://student.narad.co/api/TradeContentPDFApi/"))
                .build();


    }
    public DBComponent getDBComponent() {
        return component;
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }


}
