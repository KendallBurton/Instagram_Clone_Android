package com.example.instagram_clone_android;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("5MM8WCfd1qv1d3qpvQitmpvyShhkNff0GQ3oE57R")
                .clientKey("wI94Ey4TGRqeztb6UrwI6RpCqp3VFYNsoW6zDllz")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
