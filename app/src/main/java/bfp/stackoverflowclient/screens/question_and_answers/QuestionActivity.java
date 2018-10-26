package bfp.stackoverflowclient.screens.question_and_answers;

import android.content.Context;

import javax.inject.Inject;

import bfp.stackoverflowclient.BaseActivity;
import bfp.stackoverflowclient.questions.FetchLastActiveTaggedQuestionsUseCase;
import bfp.stackoverflowclient.questions.FetchQuestionUseCase;
import bfp.stackoverflowclient.screens.common.ViewMvcFactory;

public class QuestionActivity extends BaseActivity {
    @Inject
    ViewMvcFactory factory;
    @Inject
    FetchQuestionUseCase fetchQuestionUseCase;



}
