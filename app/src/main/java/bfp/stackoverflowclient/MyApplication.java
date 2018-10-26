package bfp.stackoverflowclient;

import android.app.Application;

import bfp.stackoverflowclient.common.dependency_injection.ApplicationComponent;
import bfp.stackoverflowclient.common.dependency_injection.DaggerApplicationComponent;

public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
