package database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haseeb on 11/5/17.
 */

public class ImageRepo {
    public static final String DATABASE_TABLE = "Image";
    public static final String KEY_DATA = "Data";
    public static final String KEY_NAME = "Name";

    public ImageRepo(){

    }


    public static String createTable(){
        return "CREATE TABLE " + DATABASE_TABLE  + "("
                + KEY_DATA  + " BLOB  ,"
                + KEY_NAME + " TEXT )";
    }


    public void insert(ImageModel imageModel) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_DATA, imageModel.getImage());
        values.put(KEY_NAME, imageModel.getName());

        // Inserting Row
        db.insert(DATABASE_TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
    }



    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(DATABASE_TABLE,null,null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public List<ImageModel> getData(){
        ImageModel model = new ImageModel();
        List<ImageModel> ImageLists = new ArrayList<ImageModel>();

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String selectQuery =  " SELECT Image." + KEY_DATA
                + ", Image." + KEY_NAME
                + " FROM " + DATABASE_TABLE;

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                model= new ImageModel();
                model.setImage(cursor.getBlob(cursor.getColumnIndex(KEY_DATA)));
                model.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                ImageLists.add(model);
            } while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return ImageLists;

    }


}
