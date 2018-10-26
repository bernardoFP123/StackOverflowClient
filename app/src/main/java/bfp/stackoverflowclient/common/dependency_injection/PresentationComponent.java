package bfp.stackoverflowclient.common.dependency_injection;


import bfp.stackoverflowclient.screens.questions.QuestionsListActivity;
import bfp.stackoverflowclient.common.PresentationScope;
import dagger.Component;
@PresentationScope
@Component(dependencies = ApplicationComponent.class,modules = PresentationModule.class)
public interface PresentationComponent {
    void inject(QuestionsListActivity questionsListActivity);
}
