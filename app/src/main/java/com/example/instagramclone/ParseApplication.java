package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("hmAVKsVNAuHmRq3ALPzgFzN5A9oYILXudPyuUl1C")
                .clientKey("d3rc1z6k27ra0TAvAOWzbr5vxHlekyHL98nicir9")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }

}
