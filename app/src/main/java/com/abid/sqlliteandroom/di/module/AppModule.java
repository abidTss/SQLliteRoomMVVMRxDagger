package com.abid.sqlliteandroom.di.module;

import android.app.Application;
import android.content.Context;

import com.abid.sqlliteandroom.di.component.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abid on 4/1/18.
 */
@Module
public class AppModule {
    private Application mApplication;
    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }
}
