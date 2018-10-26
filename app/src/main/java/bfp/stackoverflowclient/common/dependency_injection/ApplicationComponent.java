package bfp.stackoverflowclient.common.dependency_injection;


import javax.inject.Singleton;

import bfp.stackoverflowclient.answers.FetchAnswersUseCase;
import bfp.stackoverflowclient.networking.StackOverflowAPI;
import bfp.stackoverflowclient.questions.FetchGeneralQuestionsUseCase;
import bfp.stackoverflowclient.questions.FetchLastActiveTaggedQuestionsUseCase;
import bfp.stackoverflowclient.questions.FetchQuestionUseCase;
import bfp.stackoverflowclient.questions.ProgrammingLanguageNavigator;
import bfp.stackoverflowclient.questions.StoredRedableTagsUseCase;
import dagger.Component;
import dagger.Provides;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    FetchLastActiveTaggedQuestionsUseCase getFetchLastActiveTaggedQuestionsUseCase();
    FetchGeneralQuestionsUseCase getFetchGeneralQuestionsUseCase();
    ProgrammingLanguageNavigator getProgrammingLanguajeNavigator();
    StoredRedableTagsUseCase getStoredRedableTagsUseCase();
    FetchQuestionUseCase getfetchQuestionUseCase();
    FetchAnswersUseCase getFetchAnswersUseCase();
}
