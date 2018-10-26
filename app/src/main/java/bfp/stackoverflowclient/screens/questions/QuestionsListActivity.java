
package bfp.stackoverflowclient.screens.questions;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bfp.stackoverflowclient.BaseActivity;
import bfp.stackoverflowclient.questions.ProgrammingLanguageTag;
import bfp.stackoverflowclient.questions.FetchGeneralQuestionsUseCase;
import bfp.stackoverflowclient.questions.FetchLastActiveTaggedQuestionsUseCase;
import bfp.stackoverflowclient.questions.Question;
import bfp.stackoverflowclient.questions.StoredRedableTagsUseCase;
import bfp.stackoverflowclient.questions.common.FetchQuestionsUseCase;
import bfp.stackoverflowclient.questions.ProgrammingLanguageNavigator;
import bfp.stackoverflowclient.screens.common.ViewMvcFactory;

public class QuestionsListActivity extends BaseActivity implements FetchQuestionsUseCase.Listener, QuestionsListMvc.Listener, ProgrammingLanguageNavigator.Listener {


    QuestionsListMvc questionsListMvc;
    @Inject
    ProgrammingLanguageNavigator programmingLanguageNavigator;
    @Inject
    ViewMvcFactory factory;
    @Inject
    FetchLastActiveTaggedQuestionsUseCase fetchLastActiveTaggedQuestionsUseCase;
    @Inject
    FetchGeneralQuestionsUseCase fetchGeneralQuestionsUseCase;
    @Inject
    StoredRedableTagsUseCase storedRedableTagsUseCase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresentationComponent().inject(this);
        questionsListMvc = factory.getQuestionsListViewMvc(null);
        setContentView(questionsListMvc.getRootView());

    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchGeneralQuestionsUseCase.registerListener(this);
        fetchLastActiveTaggedQuestionsUseCase.registerListener(this);
        questionsListMvc.registerListener(this);
        programmingLanguageNavigator.registerListener(this);
        storedRedableTagsUseCase.getTagsAndNotify();
    }


    @Override
    protected void onStop() {
        super.onStop();
        fetchGeneralQuestionsUseCase.unregisterListener(this);
        fetchLastActiveTaggedQuestionsUseCase.unregisterListener(this);
        questionsListMvc.unRegisterListener(this);
        programmingLanguageNavigator.unregisterListener(this);
    }

    @Override
    public void onLastActiveQuestionsFetched(List<Question> questions) {
        questionsListMvc.bindQuestions(questions);
        questionsListMvc.stopRefreshing();
    }

    @Override
    public void onLastActiveQuestionsFetchFailed() {

    }

    @Override
    public void onQuestionClicked(Question question) {
        Toast.makeText(getApplicationContext(),question.getTitle(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRefresh() {
        selectQuestionsUseCase(programmingLanguageNavigator.getSelectedProgrammingLanguageTag());
        questionsListMvc.bindQuestions(new ArrayList<Question>());
    }

    public void selectQuestionsUseCase(String tagName){
        if(tagName.equals("General")){
            fetchGeneralQuestionsUseCase.fetchLastActiveQuestionsAndNotify();
        }
        else {
            fetchLastActiveTaggedQuestionsUseCase.fetchLastActiveTaggedQuestionsAndNotify(tagName);
        }
    }

    @Override
    public void onTagSelected(ProgrammingLanguageTag tag) {
        programmingLanguageNavigator.setActualProgramingLanguageAndNotify(tag);
        selectQuestionsUseCase(tag.getName());
    }

    @Override
    public void onNewTagCreated(ProgrammingLanguageTag tag) {

    }

    @Override
    public void onAddButtonClicked() {

    }

    @Override
    public void onBackPressed() {
        if(questionsListMvc.isDrawerOpen()){
            questionsListMvc.closeDrawer();
        }
        else {
            super.onBackPressed();
        }

    }


    @Override
    public void onProgrammingLanguageSelected() {

    }

    @Override
    public void onTagsReceived() {
        questionsListMvc.bindMenuOptions(programmingLanguageNavigator.getAvailableProgrammingLanguageTags());
        selectQuestionsUseCase(programmingLanguageNavigator.getSelectedProgrammingLanguageTag());
    }
}
