package com.abid.sqlliteandroom.di.component;

import com.abid.sqlliteandroom.MainActivity;
import com.abid.sqlliteandroom.di.module.AppModule;
import com.abid.sqlliteandroom.di.module.DBModule;
import com.abid.sqlliteandroom.di.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by abid on 4/1/18.
 */
@Singleton
@Component(modules = {AppModule.class, DBModule.class})
public interface DBComponent {
     void inject(MainActivity activity2);
}
