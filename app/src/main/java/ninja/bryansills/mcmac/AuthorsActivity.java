package ninja.bryansills.mcmac;

import android.content.Intent;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ninja.bryansills.mcmac.database.DatabaseHelper;
import ninja.bryansills.mcmac.database.model.Author;

public class AuthorsActivity extends AppCompatActivity {

    private RecyclerView authorList;
    private AuthorAdapter authorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authors);

        authorList = (RecyclerView) findViewById(R.id.author_list);
        authorList.setLayoutManager(new LinearLayoutManager(this));

        List<Author> authors = new ArrayList<>();

        SQLiteDatabase db = DatabaseHelper.getInstance(this).getReadableDatabase();
        Cursor cursor = db.rawQuery(Author.SELECT_ALL, new String[0]);

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Author author = Author.MAPPER.map(cursor);
            authors.add(author);
        }

        authorAdapter = new AuthorsActivity.AuthorAdapter(authors);

        authorList.setAdapter(authorAdapter);
    }

    private class AuthorAdapter extends RecyclerView.Adapter {
        private List<Author> authors;

        public AuthorAdapter(List<Author> authors) {
            this.authors = authors;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_author, parent, false);

            RecyclerView.ViewHolder vh = new AuthorsActivity.AuthorViewHolder(v);

            return vh;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((AuthorsActivity.AuthorViewHolder) holder).bind(authors.get(position));
        }

        @Override
        public int getItemCount() {
            return authors.size();
        }
    }

    private class AuthorViewHolder extends RecyclerView.ViewHolder {
        public TextView name, birthday;
        private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        public AuthorViewHolder(View v) {
            super(v);

            name = (TextView) v.findViewById(R.id.name);
            birthday = (TextView) v.findViewById(R.id.birthday);
        }

        public void bind(final Author bookAuthor) {
            name.setText(bookAuthor.name());
            birthday.setText(formatter.format(bookAuthor.birth_year().getTime()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AuthorsActivity.this, BooksActivity.class);
                    intent.putExtra(BooksActivity.AUTHOR_ID, bookAuthor._id());
                    startActivity(intent);
                }
            });
        }
    }
}
