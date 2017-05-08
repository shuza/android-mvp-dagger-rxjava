package com.nybsys.shuza.learnmvp.root;

import android.app.Application;

import com.nybsys.shuza.learnmvp.DaggerApplicationComponent;
import com.nybsys.shuza.learnmvp.login.LoginModule;

/**
 * Created by Shuza on 08-May-17.
 */

public class App extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
