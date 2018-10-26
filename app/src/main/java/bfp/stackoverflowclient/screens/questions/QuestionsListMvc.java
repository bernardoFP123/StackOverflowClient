package bfp.stackoverflowclient.screens.questions;

import java.util.List;

import bfp.stackoverflowclient.questions.Question;
import bfp.stackoverflowclient.questions.ProgrammingLanguageTag;
import bfp.stackoverflowclient.screens.common.nav_drawer.NavDrawerViewMvc;
import bfp.stackoverflowclient.screens.common.views.ObservableViewMvc;


public interface QuestionsListMvc extends ObservableViewMvc<QuestionsListMvc.Listener>,NavDrawerViewMvc {


    interface Listener{
    void onQuestionClicked(Question question);
    void onRefresh();
    void onTagSelected(ProgrammingLanguageTag tag);
    void onNewTagCreated(ProgrammingLanguageTag tag);
    void onAddButtonClicked();
}
    void bindQuestions(List<Question> questions);
    void bindMenuOptions(List<ProgrammingLanguageTag> items);
    void stopRefreshing();
    void displayTagCreationMenu(ProgrammingLanguageTag tag);
}
