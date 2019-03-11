package com.mydatabindviewmodel.app;

import android.util.Patterns;

public class User {

    public User(String mEmail, String mPassword) {
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }

    public String getEmail() {
        if (mEmail == null) {
            return "";
        }
        return mEmail;
    }


    public String getPassword() {

        if (mPassword == null) {
            return "";
        }
        return mPassword;
    }

    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }


    public boolean isPasswordLengthGreaterThan5() {
        return getPassword().length() > 5;
    }

    private String mEmail;
    private String mPassword;
}
