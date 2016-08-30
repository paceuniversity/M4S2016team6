package com.example.evelyne_ines.expensemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by evelyne-ines on 29/08/16.
 */
public class ExpenseDB {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "expenseManager";

    private static final String TABLE_EXPENSE = "expenses";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_ARTICLE= "Article";
    private static final int NUM_COL_ARTICLE = 1;
    private static final String COL_PRICE = "Prix";
    private static final int NUM_COL_PRICE = 2;

    private SQLiteDatabase bdd;

    private  DatabaseHelper maBaseSQLite;

    public ExpenseDB(Context context){
        //On crée la BDD et sa table
        maBaseSQLite = new DatabaseHelper(context, NOM_BDD, null, VERSION_BDD);
    }


    public void open(){
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertExpense(expenses expense){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_ARTICLE, expense.getArticle());
        values.put(COL_PRICE, expense.getPrice());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_EXPENSE, null, values);
    }

    public int updateExpense(int id, expenses expense){
        //La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simplement préciser quel livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_ARTICLE, expense.getArticle());
        values.put(COL_PRICE, expense.getPrice());
        return bdd.update(TABLE_EXPENSE, values, COL_ID + " = " +id, null);
    }

    public int removeExpenseWithID(int id){
        //Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(TABLE_EXPENSE, COL_ID + " = " +id, null);
    }



    private expenses cursorToExpense(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        expenses expense = new expenses();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        expense.setId(c.getInt(NUM_COL_ID));
        expense.setArticle(c.getString(NUM_COL_ARTICLE));
        expense.setPrice(Float.parseFloat(c.getString(NUM_COL_PRICE)));
        //On ferme le cursor
        c.close();

        return expense;
    }
}


