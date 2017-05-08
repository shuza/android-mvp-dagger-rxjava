package com.nybsys.shuza.learnmvp.login;

/**
 * Created by Shuza on 08-May-17.
 */

public class MemoryRepository implements LoginRepository {

    private User user;

    @Override
    public User getUser() {
        if (user == null) {
            user = new User("Shuza", "Sa");
            user.setId(0);
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        if (user == null) {
            user = getUser();
        }
        this.user = user;
    }
}
