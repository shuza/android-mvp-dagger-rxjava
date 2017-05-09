package com.nybsys.shuza.learnmvp;

import com.nybsys.shuza.learnmvp.login.LoginActivityMVP;
import com.nybsys.shuza.learnmvp.login.LoginActivityPresenter;
import com.nybsys.shuza.learnmvp.login.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by Shuza on 09-May-17.
 */

public class PresenterTests {
    private LoginActivityMVP.Model mockLoginModel;
    private LoginActivityMVP.View mockView;
    private LoginActivityPresenter presenter;
    private User user;

    @Before
    public void setup() {
        mockLoginModel = mock(LoginActivityMVP.Model.class);
        user = new User("Fox", "Mulder");
        mockView = mock(LoginActivityMVP.View.class);

        presenter = new LoginActivityPresenter(mockLoginModel);
        presenter.setView(mockView);
    }

    @Test
    public void loadTheUserFromRepositoryWhenValidUserIsPresent() {
        when(mockLoginModel.getUser()).thenReturn(user);
        presenter.getCurrentUser();

        verify(mockLoginModel, times(1)).getUser();

        verify(mockView, times(1)).setFirstName("Fox");
        verify(mockView, times(1)).setLastName("Mulder");
        verify(mockView, never()).showUserNotAvailable();
    }

    @Test
    public void shouldShowErrorMessageWhenUserIsNull() {
        when(mockLoginModel.getUser()).thenReturn(null);
        presenter.getCurrentUser();

        verify(mockLoginModel, times(1)).getUser();

        verify(mockView, never()).setFirstName("Fox");
        verify(mockView, never()).setLastName("Mulder");
        verify(mockView, times(1)).showUserNotAvailable();
    }

}
