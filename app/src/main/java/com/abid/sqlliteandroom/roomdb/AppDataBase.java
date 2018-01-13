package com.abid.sqlliteandroom.roomdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.abid.sqlliteandroom.di.component.ApplicationContext;

import javax.inject.Inject;

/**
 * Created by abid on 5/1/18.
 */
@Database(entities = {UserInfo.class},version = 1)
public abstract class AppDataBase extends RoomDatabase{
    public static AppDataBase INSTANSE;
    public abstract UserDao userDao();

    public static AppDataBase getAppDatabase(Context context){
        if(INSTANSE==null){
            INSTANSE= Room.databaseBuilder(context,AppDataBase.class,"mydb.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANSE;
    }
    public static void destroyInstance(){
        INSTANSE=null;
    }

}
