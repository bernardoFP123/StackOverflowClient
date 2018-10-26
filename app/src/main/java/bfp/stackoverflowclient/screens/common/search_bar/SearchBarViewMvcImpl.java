package bfp.stackoverflowclient.screens.common.search_bar;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import bfp.stackoverflowclient.R;
import bfp.stackoverflowclient.screens.common.views.BaseObservableViewMvc;


public class SearchBarViewMvcImpl extends BaseObservableViewMvc<SearchBarViewMvc.Listener> implements SearchBarViewMvc {

    EditText searchText;
    ImageView deleteButton;

    public SearchBarViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent){
        setRootView(inflater.inflate(R.layout.search_bar_layout,parent,false));
        searchText = findViewById(R.id.editTextSearchString);
        deleteButton = findViewById(R.id.imageViewClearButton);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchText.setText("");
                //new FadeOut().execute(new Integer(1));
                fadeOutAnim();
            }
        });


        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(searchText.getText().toString().equals("")){
                    enlargeInAnim();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    hideSoftKeyboard(v);
                    for(Listener listener : getmListeners()){
                        listener.onSearchEntered(searchText.getText().toString());
                    }
                    //new FadeOut().execute(new Integer(1));
                    fadeOutAnim();
                    handled = true;
                }


                return handled;

            }
        });
    }

    private class FadeOut extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected Integer doInBackground(Integer... integers) {
            fadeOutAnim();
            return null;
        }
    }

    private void fadeOutAnim() {
        AnimatorSet ast = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(),R.animator.fade_out);
        ast.setTarget(deleteButton);
        ast.start();
    }
    private void enlargeInAnim() {
        deleteButton.setVisibility(View.VISIBLE);
        AnimatorSet ast = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(),R.animator.jump_in);
        ast.setTarget(deleteButton);
        ast.start();

    }

    @Override
    public void showBar() {
        searchText.setText("");
        getRootView().setVisibility(View.VISIBLE);
        showSoftKeyboard(searchText);
        deleteButton.setVisibility(View.GONE);
    }

    @Override
    public void hideBar() {
        getRootView().setVisibility(View.GONE);
    }
    public void hideSoftKeyboard(View view){
        InputMethodManager imm =(InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public void showSoftKeyboard(View view){
        if(view.requestFocus()){
            InputMethodManager imm =(InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view,InputMethodManager.SHOW_IMPLICIT);
        }
    }
}
