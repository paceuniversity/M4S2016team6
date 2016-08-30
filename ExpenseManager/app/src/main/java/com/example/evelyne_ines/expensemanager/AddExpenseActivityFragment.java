package com.example.evelyne_ines.expensemanager;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddExpenseActivityFragment extends Fragment implements View.OnClickListener {


    public AddExpenseActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_add_expense, container, false);


        return rootView;
    }

    @Override
    public void onClick(View view) {

    }
}
