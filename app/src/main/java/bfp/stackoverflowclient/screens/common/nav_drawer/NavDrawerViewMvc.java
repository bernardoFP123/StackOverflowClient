package bfp.stackoverflowclient.screens.common.nav_drawer;

import java.util.List;

import bfp.stackoverflowclient.questions.ProgrammingLanguageTag;

public interface NavDrawerViewMvc {
    boolean isDrawerOpen();
    void openDrawer();
    void closeDrawer();
    void bindMenu(List<ProgrammingLanguageTag> questionSets);
}
