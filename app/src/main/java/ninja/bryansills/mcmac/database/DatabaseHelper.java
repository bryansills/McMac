package ninja.bryansills.mcmac.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ninja.bryansills.mcmac.database.model.Author;
import ninja.bryansills.mcmac.database.model.Book;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static DatabaseHelper instance;

    public static DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    public DatabaseHelper(Context context) {
        super(context, null, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Author.CREATE_TABLE);
        db.execSQL(Book.CREATE_TABLE);

        populateDb(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void populateDb(SQLiteDatabase db) {
    }
}
