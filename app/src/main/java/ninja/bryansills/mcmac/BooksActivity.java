package ninja.bryansills.mcmac;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.sqldelight.SqlDelightStatement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ninja.bryansills.mcmac.database.DatabaseHelper;
import ninja.bryansills.mcmac.database.model.Author;
import ninja.bryansills.mcmac.database.model.Book;

public class BooksActivity extends AppCompatActivity {

    public static final String AUTHOR_ID = "AUTHOR_ID";
    private RecyclerView bookList;
    private BookAdapter bookAdapter;

    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        bookList = (RecyclerView) findViewById(R.id.book_list);
        bookList.setLayoutManager(new LinearLayoutManager(this));

        List<Book> books = new ArrayList<>();
        List<Author> authors = new ArrayList<>();

        SQLiteDatabase db = DatabaseHelper.getInstance(this).getReadableDatabase();
        long authorId = getIntent().getLongExtra(AUTHOR_ID, -1);

        if (authorId == -1) {
            cursor = db.rawQuery(Book.SELECT_ALL, null);
        } else {
            SqlDelightStatement bookForAuthor = Book.FACTORY.for_author(authorId);
            cursor = db.rawQuery(bookForAuthor.statement, bookForAuthor.args);
        }

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Book.ForAuthor bookForAuthor = Book.FOR_AUTHOR_MAPPER.map(cursor);
            books.add(bookForAuthor.book());
            authors.add(bookForAuthor.author());
        }

        bookAdapter = new BookAdapter(books, authors);

        bookList.setAdapter(bookAdapter);
    }

    private class BookAdapter extends RecyclerView.Adapter {
        private List<Book> books;
        private List<Author> authors;

        public BookAdapter(List<Book> books, List<Author> authors) {
            this.books = books;
            this.authors = authors;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book, parent, false);

            RecyclerView.ViewHolder vh = new BookViewHolder(v);

            return vh;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((BookViewHolder) holder).bind(books.get(position), authors.get(position));
        }

        @Override
        public int getItemCount() {
            return books.size();
        }
    }

    private class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView title, author, genre, publishDate;
        private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        public BookViewHolder(View v) {
            super(v);

            title = (TextView) v.findViewById(R.id.title);
            author = (TextView) v.findViewById(R.id.author);
            genre = (TextView) v.findViewById(R.id.genre);
            publishDate = (TextView) v.findViewById(R.id.publish_date);
        }

        public void bind(Book book, Author bookAuthor) {
            title.setText(book.title());
            author.setText(bookAuthor.name());
            genre.setText(book.genre().name());
            publishDate.setText(formatter.format(book.release_year().getTime()));
        }
    }
}
