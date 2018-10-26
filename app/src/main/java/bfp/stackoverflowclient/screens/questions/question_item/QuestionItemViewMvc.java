package bfp.stackoverflowclient.screens.questions.question_item;

import bfp.stackoverflowclient.questions.Question;
import bfp.stackoverflowclient.screens.common.views.ObservableViewMvc;

public interface QuestionItemViewMvc extends ObservableViewMvc<QuestionItemViewMvc.Listener> {

    interface Listener{
        void onQuestionClicked(Question question);
    }
    void bindQuestion(Question question);

}
