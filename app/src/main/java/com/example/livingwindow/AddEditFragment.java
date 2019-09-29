package com.example.livingwindow;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.text.TextWatcher;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.net.Uri;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.LoaderManager;

public class AddEditFragment extends Fragment {
    public interface AddEditFragmentListener
            //?implements LoaderManager.LoaderCallbacks
    {
        void onAddEditCompleted(/*SQL data */);
    }

    private AddEditFragmentListener listener;
    private TextInputLayout sensor1text;
    private TextInputLayout sensor2text;
    private TextInputLayout sensor3text;

    //set AddEditFragmentListener when Fragment attached
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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //setHasOptionsMenu(true);// fragment has items to display?

    View view = inflater.inflate(R.layout.add_edit_fragment, container, false);
   /*
    sensor1text = (TextInputLayout) view.findViewById(R.id.tempHumText);
    sensor2text = (TextInputLayout) view.findViewById(R.id.waterproofSensorText);
    sensor3text = (TextInputLayout) view.findViewById (R.id.pHsensorText);
    */





    return view;
    }
}




