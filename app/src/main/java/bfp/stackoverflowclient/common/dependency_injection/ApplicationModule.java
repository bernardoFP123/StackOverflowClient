package bfp.stackoverflowclient.common.dependency_injection;

import javax.inject.Singleton;

import bfp.stackoverflowclient.answers.FetchAnswersUseCase;
import bfp.stackoverflowclient.common.Constants;
import bfp.stackoverflowclient.networking.StackOverflowAPI;
import bfp.stackoverflowclient.questions.FetchGeneralQuestionsUseCase;
import bfp.stackoverflowclient.questions.FetchLastActiveTaggedQuestionsUseCase;
import bfp.stackoverflowclient.questions.FetchQuestionUseCase;
import bfp.stackoverflowclient.questions.ProgrammingLanguageNavigator;
import bfp.stackoverflowclient.questions.StoredRedableTagsUseCase;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class ApplicationModule {

    @Singleton
    @Provides
    Retrofit getRetrofit(){

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    @Singleton
    @Provides
    StackOverflowAPI getStackOverflowAPI(Retrofit retrofit){

        return retrofit.create(StackOverflowAPI.class);
    }
    @Provides
    FetchLastActiveTaggedQuestionsUseCase getFetchLastActiveTaggedQuestionsUseCase(StackOverflowAPI stackOverflowAPI){
        return new FetchLastActiveTaggedQuestionsUseCase(stackOverflowAPI);
    }
    @Provides
    FetchGeneralQuestionsUseCase getFetchGeneralQuestionsUseCase(StackOverflowAPI stackOverflowAPI){
        return new FetchGeneralQuestionsUseCase(stackOverflowAPI);
    }
    @Provides
    FetchQuestionUseCase getfetchQuestionUseCase(StackOverflowAPI stackOverflowAPI){
        return new FetchQuestionUseCase(stackOverflowAPI);
    }
    @Provides
    FetchAnswersUseCase getFetchAnswersUseCase(StackOverflowAPI stackOverflowAPI){
        return new FetchAnswersUseCase(stackOverflowAPI);
    }
     @Provides
     @Singleton
     ProgrammingLanguageNavigator getProgrammingLanguajeNavigator(){
        return new ProgrammingLanguageNavigator();
     }
     @Provides
    StoredRedableTagsUseCase getStoredRedableTagsUseCase(ProgrammingLanguageNavigator programmingLanguageNavigator){
        return new StoredRedableTagsUseCase(programmingLanguageNavigator);
     }

}
