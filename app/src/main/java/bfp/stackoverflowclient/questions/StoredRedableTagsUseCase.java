package bfp.stackoverflowclient.questions;

import java.util.ArrayList;

import bfp.stackoverflowclient.common.BaseObservable;

public class StoredRedableTagsUseCase extends BaseObservable<StoredRedableTagsUseCase.Listener> {

    public interface Listener{
        void receivedStoredTags();
    }
    ProgrammingLanguageNavigator programmingLanguageNavigator;
    public StoredRedableTagsUseCase(ProgrammingLanguageNavigator programmingLanguageNavigator) {
        this.programmingLanguageNavigator = programmingLanguageNavigator;
    }

    public void  getTagsAndNotify(){
        ArrayList<ProgrammingLanguageTag> tags = new ArrayList<>();
        tags.add(new ProgrammingLanguageTag("General",""));
        tags.add(new ProgrammingLanguageTag("Android","android"));
        tags.add(new ProgrammingLanguageTag("IOS","ios"));
        tags.add(new ProgrammingLanguageTag("Python","python"));

        programmingLanguageNavigator.setAvailableProgrammingLanguageTagsAndNotify(tags);
    }
}
