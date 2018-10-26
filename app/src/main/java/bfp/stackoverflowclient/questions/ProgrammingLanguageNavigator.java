package bfp.stackoverflowclient.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bfp.stackoverflowclient.common.BaseObservable;

public class ProgrammingLanguageNavigator extends BaseObservable<ProgrammingLanguageNavigator.Listener>{


    public interface Listener{
        void onProgrammingLanguageSelected();
        void onTagsReceived();
    }


    ProgrammingLanguageTag selectedProgrammingLanguageTag;
    List<ProgrammingLanguageTag> availableProgrammingLanguageTags = new ArrayList<>();

    public ProgrammingLanguageNavigator() {
    }

    public void setActualProgramingLanguageAndNotify(ProgrammingLanguageTag tag){
        selectedProgrammingLanguageTag = tag;
        for(Listener listener : getListeners()){
            listener.onProgrammingLanguageSelected();
        }
    }

    public void setAvailableProgrammingLanguageTagsAndNotify(List<ProgrammingLanguageTag> availableProgrammingLanguageTags) {
        this.availableProgrammingLanguageTags = availableProgrammingLanguageTags;
        this.setActualProgramingLanguageAndNotify(getFirstTag());
        for(Listener listener : getListeners()){
            listener.onTagsReceived();
        }
    }

    public List<ProgrammingLanguageTag> getAvailableProgrammingLanguageTags() {
        return Collections.unmodifiableList(availableProgrammingLanguageTags);
    }
    public String getSelectedProgrammingLanguageTag() {
        return selectedProgrammingLanguageTag.getTag();
    }

    private ProgrammingLanguageTag getFirstTag(){
        return availableProgrammingLanguageTags.get(0);
    }
}
