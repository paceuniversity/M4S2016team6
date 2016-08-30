package com.example.evelyne_ines.expensemanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddExpenseActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etArticle, etPrix;
    private Button btnValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etArticle = (EditText)findViewById(R.id.etArticle);
        etPrix = (EditText)findViewById(R.id.etPrix);
        btnValider = (Button)findViewById(R.id.btnValider);
        btnValider.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnValider){
            String article = etArticle.getText().toString();
            float price = Float.parseFloat(String.valueOf(etPrix.getText()));
            expenses exp = new expenses(article,price,null);
            ExpenseDB expenseDB = new ExpenseDB(this);
            expenseDB.open();
            expenseDB.insertExpense(exp);
            Toast.makeText(this, "Dépense enregistrée", Toast.LENGTH_SHORT).show();
            expenseDB.close();

        }
    }
}
