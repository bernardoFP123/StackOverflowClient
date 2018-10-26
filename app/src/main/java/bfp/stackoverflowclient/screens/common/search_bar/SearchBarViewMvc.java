package bfp.stackoverflowclient.screens.common.search_bar;


import bfp.stackoverflowclient.screens.common.views.ObservableViewMvc;

public interface SearchBarViewMvc extends ObservableViewMvc<SearchBarViewMvc.Listener> {
    interface Listener{
        void onSearchEntered(String searchString);
    }

    void showBar();
    void hideBar();

}
