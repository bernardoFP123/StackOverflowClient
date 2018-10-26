package bfp.stackoverflowclient.screens.common.views;

public interface ObservableViewMvc<ListenerType> extends ViewMvc {

    void registerListener(ListenerType listener);

    void unRegisterListener(ListenerType listener);

}
