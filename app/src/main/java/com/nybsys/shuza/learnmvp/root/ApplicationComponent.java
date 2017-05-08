package com.nybsys.shuza.learnmvp.root;

import com.nybsys.shuza.learnmvp.login.LoginActivity;
import com.nybsys.shuza.learnmvp.login.LoginModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Shuza on 08-May-17.
 */
@Singleton
@Component(modules = {ApplicationModule.class, LoginModel.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);

}
