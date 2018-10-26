package bfp.stackoverflowclient.questions.common;

import java.util.ArrayList;
import java.util.List;

import bfp.stackoverflowclient.common.BaseObservable;
import bfp.stackoverflowclient.networking.StackOverflowAPI;
import bfp.stackoverflowclient.networking.questions.QuestionSchema;
import bfp.stackoverflowclient.questions.Question;

public class FetchQuestionsUseCase extends BaseObservable<FetchQuestionsUseCase.Listener> {
    public interface Listener {
        void onLastActiveQuestionsFetched(List<Question> questions);
        void onLastActiveQuestionsFetchFailed();
    }
    protected final StackOverflowAPI stackOverflowAPI;

    public FetchQuestionsUseCase(StackOverflowAPI stackOverflowAPI) {
        this.stackOverflowAPI = stackOverflowAPI;
    }
    protected void notifyFailure() {
        for (Listener listener : getListeners()) {
            listener.onLastActiveQuestionsFetchFailed();
        }
    }

    protected void notifySuccess(List<QuestionSchema> questionSchemas) {
        List<Question> questions = new ArrayList<>(questionSchemas.size());
        for (QuestionSchema questionSchema : questionSchemas) {
            questions.add(new Question(questionSchema.getQuestionId(), questionSchema.getTitle()));
        }
        for (Listener listener : getListeners()) {
            listener.onLastActiveQuestionsFetched(questions);
        }
    }
}
