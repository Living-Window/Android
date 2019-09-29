package com.example.livingwindow;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class displayFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.display_fragment, container, false);
        return view;
        // return super.onCreateView(inflater, container, savedInstanceState);

        //in this spot
        // edit textbox with SQL data
        //find that in gitHub.
        // there is "AddEditFragment.java"
        // look at the code, "TextInputLayout"
        // textboxes:
        // access textboxes, update with current SQL data

    //ok like where/what are the textboxes?
        //all the textboxes comprise this very fragment, displayFragment
        //displayFragment.xml has all the textboxes! you can see them there if you want
        //so we're like dealing with the contents of this fragment right now
        //telling this fragment what to do

        //which is put your text into the textboxes of yourself
        //the text is the updated SQL data that is coming from the sensors
        //so like the string of the text in the boxes equals like the sensor data

    }
}
