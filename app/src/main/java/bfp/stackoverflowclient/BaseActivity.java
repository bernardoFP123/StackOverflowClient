package bfp.stackoverflowclient;

import android.support.v7.app.AppCompatActivity;

import bfp.stackoverflowclient.common.dependency_injection.ApplicationComponent;
import bfp.stackoverflowclient.common.dependency_injection.DaggerPresentationComponent;
import bfp.stackoverflowclient.common.dependency_injection.PresentationComponent;
import bfp.stackoverflowclient.common.dependency_injection.PresentationModule;

public class BaseActivity extends AppCompatActivity {

    private boolean isInjectorUsed;


    private ApplicationComponent getApplicationComponent(){
        return ((MyApplication)getApplication()).getApplicationComponent();
    }

    protected PresentationComponent getPresentationComponent(){
        if(isInjectorUsed){
            throw new RuntimeException("There is no need to use injector more than once");
        }
        isInjectorUsed = true;
        return DaggerPresentationComponent.builder()
                .presentationModule(new PresentationModule(this))
                .applicationComponent(getApplicationComponent())
                .build();
    }
}
