package bfp.stackoverflowclient.screens.common.tool_bar;

import bfp.stackoverflowclient.screens.common.views.ObservableViewMvc;
import bfp.stackoverflowclient.screens.common.views.ViewMvc;

public interface ToolBarViewMvc extends ViewMvc {
    void setTitle(String title);

    void enableHamburgerButtonAndListen(HamburgerClickListener hamburgerClickListener);

    void enableUpButtonAndListen(NavigateUpClickListener navigateUpClickListener);

    void enableAddButtonAndListen(AddButtonClickListener addButtonClickListener);

    public interface NavigateUpClickListener {
        void onNavigateUpClicked();
    }

    public interface AddButtonClickListener {
        void onAddButtonClicked();
    }

    public interface HamburgerClickListener {
        void onHamburgerClicked();
    }
    void showBar();
    void hideBar();
}
