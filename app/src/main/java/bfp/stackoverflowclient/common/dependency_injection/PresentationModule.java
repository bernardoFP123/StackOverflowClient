package bfp.stackoverflowclient.common.dependency_injection;

import android.app.Activity;
import android.view.LayoutInflater;

import bfp.stackoverflowclient.screens.common.ViewMvcFactory;
import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {
    Activity activity;

    public PresentationModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    public LayoutInflater getLayoutInflater(){
        return activity.getLayoutInflater();
    }
    @Provides
    public Activity getActivity(){
        return activity;
    }


    @Provides
    public ViewMvcFactory getViewMvcFactory(LayoutInflater inflater){
            return new ViewMvcFactory(inflater);
    }

}
