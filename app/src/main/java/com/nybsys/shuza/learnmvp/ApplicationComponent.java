package com.nybsys.shuza.learnmvp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Shuza on 08-May-17.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MainActivity target);

}
