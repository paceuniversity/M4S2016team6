package com.example.evelyne_ines.expensemanager;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramotion.foldingcell.FoldingCell;

/**
 * A placeholder fragment containing a simple view.
 */
public class ShoppingHelpActivityFragment extends Fragment {

    public ShoppingHelpActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_shopping_help, container, false);

        final FoldingCell fc= (FoldingCell)rootView.findViewById(R.id.folding_cell);
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
            }
        });

        final FoldingCell fc2= (FoldingCell)rootView.findViewById(R.id.folding_cell2);
        fc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc2.toggle(false);
            }
        });
        return rootView;
    }
}
