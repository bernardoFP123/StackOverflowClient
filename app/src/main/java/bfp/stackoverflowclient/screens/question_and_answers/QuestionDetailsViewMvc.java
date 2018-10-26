package bfp.stackoverflowclient.screens.question_and_answers;

import bfp.stackoverflowclient.questions.Question;
import bfp.stackoverflowclient.screens.common.views.ObservableViewMvc;

public interface QuestionDetailsViewMvc extends ObservableViewMvc<QuestionDetailsViewMvc.Listener> {
    interface Listener{
        void onBackPressed();
    }

    void bindQuestion(Question question);
}
