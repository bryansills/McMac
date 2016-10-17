package ninja.bryansills.mcmac.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.GregorianCalendar;

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
        long rowling = db.insert(Author.TABLE_NAME, null, Author.FACTORY.marshal()
                .name("J.K. Rowling")
                .birth_year(new GregorianCalendar(1965, 7, 31))
                .asContentValues());

        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0001")
                .title("Harry Potter and the Philosopher's Stone")
                .author(rowling)
                .release_year(new GregorianCalendar(1997, 6, 26))
                .genre(Book.Genre.FANTASY)
                .asContentValues());
        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0002")
                .title("Harry Potter and the Chamber of Secrets")
                .author(rowling)
                .release_year(new GregorianCalendar(1998, 7, 2))
                .genre(Book.Genre.FANTASY)
                .asContentValues());
        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0003")
                .title("Harry Potter and the Prisoner of Azkaban")
                .author(rowling)
                .release_year(new GregorianCalendar(1999, 7, 8))
                .genre(Book.Genre.FANTASY)
                .asContentValues());
        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0004")
                .title("Harry Potter and the Goblet of Fire")
                .author(rowling)
                .release_year(new GregorianCalendar(2000, 7, 8))
                .genre(Book.Genre.FANTASY)
                .asContentValues());

        long angelou = db.insert(Author.TABLE_NAME, null, Author.FACTORY.marshal()
                .name("Maya Angelou")
                .birth_year(new GregorianCalendar(1928, 4, 4))
                .asContentValues());

        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0005")
                .title("I Know Why the Caged Bird Sings")
                .author(angelou)
                .release_year(new GregorianCalendar(1969, 1, 1))
                .genre(Book.Genre.BIOGRAPHY)
                .asContentValues());
        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0006")
                .title("On the Pulse of Morning")
                .author(angelou)
                .release_year(new GregorianCalendar(1993, 1, 20))
                .genre(Book.Genre.POEM)
                .asContentValues());

        long lee = db.insert(Author.TABLE_NAME, null, Author.FACTORY.marshal()
                .name("Harper Lee")
                .birth_year(new GregorianCalendar(1926, 4, 28))
                .asContentValues());

        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0007")
                .title("To Kill a Mockingbird")
                .author(lee)
                .release_year(new GregorianCalendar(1960, 7, 11))
                .genre(Book.Genre.DRAMA)
                .asContentValues());

        long coates = db.insert(Author.TABLE_NAME, null, Author.FACTORY.marshal()
                .name("Ta-Nehisi Coates")
                .birth_year(new GregorianCalendar(1975, 9, 30))
                .asContentValues());

        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0008")
                .title("Between the World and Me")
                .author(coates)
                .release_year(new GregorianCalendar(2015, 7, 1))
                .genre(Book.Genre.BIOGRAPHY)
                .asContentValues());

        long vonnegut = db.insert(Author.TABLE_NAME, null, Author.FACTORY.marshal()
                .name("Kurt Vonnegut")
                .birth_year(new GregorianCalendar(1922, 11, 11))
                .asContentValues());

        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0009")
                .title("Slaughterhouse-Five")
                .author(vonnegut)
                .release_year(new GregorianCalendar(1969, 1, 1))
                .genre(Book.Genre.SATIRE)
                .asContentValues());
        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0010")
                .title("The Sirens of Titan")
                .author(vonnegut)
                .release_year(new GregorianCalendar(1959, 1, 1))
                .genre(Book.Genre.SATIRE)
                .asContentValues());
        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0011")
                .title("Cat's Cradle")
                .author(vonnegut)
                .release_year(new GregorianCalendar(1963, 1, 1))
                .genre(Book.Genre.SATIRE)
                .asContentValues());

        long hosseini = db.insert(Author.TABLE_NAME, null, Author.FACTORY.marshal()
                .name("Khaled Hosseini")
                .birth_year(new GregorianCalendar(1965, 3, 4))
                .asContentValues());

        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0012")
                .title("The Kite Runner")
                .author(hosseini)
                .release_year(new GregorianCalendar(2003, 5, 29))
                .genre(Book.Genre.DRAMA)
                .asContentValues());

        long neruda = db.insert(Author.TABLE_NAME, null, Author.FACTORY.marshal()
                .name("Pablo Neruda")
                .birth_year(new GregorianCalendar(1904, 7, 12))
                .asContentValues());

        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0013")
                .title("Twenty Love Poems and a Song of Despair")
                .author(neruda)
                .release_year(new GregorianCalendar(1924, 1, 1))
                .genre(Book.Genre.POEM)
                .asContentValues());

        long hemingway = db.insert(Author.TABLE_NAME, null, Author.FACTORY.marshal()
                .name("Ernest Hemingway")
                .birth_year(new GregorianCalendar(1899, 7, 21))
                .asContentValues());

        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0014")
                .title("The Old Man and the Sea")
                .author(hemingway)
                .release_year(new GregorianCalendar(1952, 1, 1))
                .genre(Book.Genre.DRAMA)
                .asContentValues());
        db.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                .isbn("0015")
                .title("A Farewell to Arms")
                .author(hemingway)
                .release_year(new GregorianCalendar(1929, 1, 1))
                .genre(Book.Genre.DRAMA)
                .asContentValues());
    }
}
