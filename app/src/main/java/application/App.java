package application;

import android.app.Application;
import android.content.Context;

import database.DBHelper;
import database.DatabaseManager;


/**
 * Created by haseeb on 11/5/17.
 */

public class App extends Application {
    private static Context context;
    private static DBHelper dbHelper;

    @Override
    public void onCreate()
    {
        super.onCreate();
        context = this.getApplicationContext();
        dbHelper = new DBHelper();
        DatabaseManager.initializeInstance(dbHelper);

    }


    public static Context getContext(){
        return context;
    }

}
