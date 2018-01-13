package com.abid.sqlliteandroom.di.module;

import android.content.Context;

import com.abid.sqlliteandroom.DbHelper;
import com.abid.sqlliteandroom.di.component.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abid on 4/1/18.
 */
@Module
public class DBModule {
    @Provides
    @Singleton
    @Inject
    DbHelper provideDbHelper(@ApplicationContext Context context){
        return new DbHelper(context);
    }
}
