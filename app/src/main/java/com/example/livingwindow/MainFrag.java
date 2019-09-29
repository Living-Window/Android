/*
package com.example.livingwindow;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.database.Cursor;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public static class MainFrag extends Fragment {
    Button btn1;
    @Nullable
    @Override

    private final View.OnClickListener btnClicked = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
// do whatever the button is supposed to do here
                    //load SQL data, send to mainActivity
                    ((InputMethodManager) getActivity().getSystemService(
                            Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                            getView().getWindowToken(), 0);
                //button does whatever it's supposed to do
                }
            };
};

    /* TODO delete this when button works perfectly
        btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            sqliteOpenHelper  = new MySQLiteOpenHelper(getApplicationContext());
            myDatabase = sqliteOpenHelper.getWritableDatabase();
            Cursor cursor = myDatabase.rawQuery("select * from lettuce;", null);
            System.out.println("MainActivity.onClick:" + cursor.getColumnCount());
        }
    //public mainFrag (){}
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        btn1 = (Button) view.findViewById(R.id.btnCreateDatabase);
        btn1.setOnClickListener(btnClicked);
        return view;
    }
    //onattach
    //ondetach

        ;
    }); */


//TODO watch onattach and ondetach so they're not deleted accidentally
    /* if onattach and ondetach go here then:
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (AddEditFragmentListener) context;
    }

    //remove AddEditFragmentListener when Fragment detached
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
     */
