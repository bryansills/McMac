package ninja.bryansills.mcmac.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.GregorianCalendar;

import ninja.bryansills.mcmac.database.model.Author;
import ninja.bryansills.mcmac.database.model.AuthorModel;
import ninja.bryansills.mcmac.database.model.Book;
import ninja.bryansills.mcmac.database.model.BookModel;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "McMac.db";
    private static final int DATABASE_VERSION = 1;

    private static DatabaseHelper instance;

    public static DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
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
        Author.Insert_author insertAuthor = new AuthorModel.Insert_author(db, Author.FACTORY);
        Book.Insert_book insertBook = new BookModel.Insert_book(db, Book.FACTORY);

        insertAuthor.bind("J.K. Rowling", new GregorianCalendar(1965, 7, 31));
        long rowling = insertAuthor.program.executeInsert();

        insertBook.bind("0001", "Harry Potter and the Philosopher's Stone", rowling, new GregorianCalendar(1997, 6, 26), Book.Genre.FANTASY);
        insertBook.program.executeInsert();
        insertBook.bind("0002", "Harry Potter and the Chamber of Secrets", rowling, new GregorianCalendar(1998, 7, 2), Book.Genre.FANTASY);
        insertBook.program.executeInsert();
        insertBook.bind("0003", "Harry Potter and the Prisoner of Azkaban", rowling, new GregorianCalendar(1999, 7, 8), Book.Genre.FANTASY);
        insertBook.program.executeInsert();
        insertBook.bind("0004", "Harry Potter and the Goblet of Fire", rowling, new GregorianCalendar(2000, 7, 8), Book.Genre.FANTASY);
        insertBook.program.executeInsert();

        insertAuthor.bind("Maya Angelou", new GregorianCalendar(1928, 4, 4));
        long angelou = insertAuthor.program.executeInsert();

        insertBook.bind("0005", "I Know Why the Caged Bird Sings", angelou, new GregorianCalendar(1969, 1, 1), Book.Genre.BIOGRAPHY);
        insertBook.program.executeInsert();
        insertBook.bind("0006", "On the Pulse of Morning", angelou, new GregorianCalendar(1993, 1, 20), Book.Genre.POEM);
        insertBook.program.executeInsert();

        insertAuthor.bind("Harper Lee", new GregorianCalendar(1926, 4, 28));
        long lee = insertAuthor.program.executeInsert();

        insertBook.bind("0007", "To Kill a Mockingbird", lee, new GregorianCalendar(1960, 7, 11), Book.Genre.DRAMA);
        insertBook.program.executeInsert();


        insertAuthor.bind("Ta-Nehisi Coates", new GregorianCalendar(1975, 9, 30));
        long coates = insertAuthor.program.executeInsert();

        insertBook.bind("0008", "Between the World and Me", coates, new GregorianCalendar(2015, 7, 1), Book.Genre.BIOGRAPHY);
        insertBook.program.executeInsert();


        insertAuthor.bind("Kurt Vonnegut", new GregorianCalendar(1922, 11, 11));
        long vonnegut = insertAuthor.program.executeInsert();

        insertBook.bind("0009", "Slaughterhouse-Five", vonnegut, new GregorianCalendar(1969, 1, 1), Book.Genre.SATIRE);
        insertBook.program.executeInsert();
        insertBook.bind("0010", "The Sirens of Titan", vonnegut, new GregorianCalendar(1959, 1, 1), Book.Genre.SATIRE);
        insertBook.program.executeInsert();
        insertBook.bind("0011", "Cat's Cradle", vonnegut, new GregorianCalendar(1963, 1, 1), Book.Genre.SATIRE);
        insertBook.program.executeInsert();

        insertAuthor.bind("Khaled Hosseini", new GregorianCalendar(1965, 3, 4));
        long hosseini = insertAuthor.program.executeInsert();

        insertBook.bind("0012", "The Kite Runner", hosseini, new GregorianCalendar(2003, 5, 29), Book.Genre.DRAMA);
        insertBook.program.executeInsert();

        insertAuthor.bind("Pablo Neruda", new GregorianCalendar(1904, 7, 12));
        long neruda = insertAuthor.program.executeInsert();

        insertBook.bind("0013", "Twenty Love Poems and a Song of Despair", neruda, new GregorianCalendar(1924, 1, 1), Book.Genre.POEM);
        insertBook.program.executeInsert();

        insertAuthor.bind("Ernest Hemingway", new GregorianCalendar(1899, 7, 21));
        long hemingway = insertAuthor.program.executeInsert();

        insertBook.bind("0014", "The Old Man and the Sea", hemingway, new GregorianCalendar(1952, 1, 1), Book.Genre.DRAMA);
        insertBook.program.executeInsert();
        insertBook.bind("0015", "A Farewell to Arms", hemingway, new GregorianCalendar(1929, 1, 1), Book.Genre.DRAMA);
        insertBook.program.executeInsert();
    }
}
