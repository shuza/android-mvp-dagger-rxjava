package com.nybsys.shuza.learnmvp.login;

import dagger.Module;

/**
 * Created by Shuza on 08-May-17.
 */

public class LoginModel implements LoginActivityMVP.Model {

    private LoginRepository repository;

    public LoginModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String firstName, String lastName) {
        repository.saveUser(new User(firstName, lastName));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
