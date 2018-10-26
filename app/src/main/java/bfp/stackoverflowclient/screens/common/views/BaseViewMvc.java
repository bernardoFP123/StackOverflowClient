package bfp.stackoverflowclient.screens.common.views;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.View;

public class BaseViewMvc implements ViewMvc {

    View mRootView;
    @Override
    public View getRootView() {
        return mRootView;
    }
    protected void setRootView(View mRootView) {
        this.mRootView = mRootView;
    }

    protected <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    protected Context getContext() {
        return getRootView().getContext();
    }

    protected String getString(@StringRes int id) {
        return getContext().getString(id);
    }
}
