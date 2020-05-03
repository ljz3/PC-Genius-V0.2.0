package com.example.pcgenius.ui.builds;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BuildsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BuildsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is builds fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}