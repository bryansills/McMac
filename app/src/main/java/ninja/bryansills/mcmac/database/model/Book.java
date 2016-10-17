package ninja.bryansills.mcmac.database.model;

import com.google.auto.value.AutoValue;
import com.squareup.sqldelight.ColumnAdapter;
import com.squareup.sqldelight.EnumColumnAdapter;
import com.squareup.sqldelight.RowMapper;

import ninja.bryansills.mcmac.database.adapter.DateAdapter;

@AutoValue
public abstract class Book implements BookModel {

    public enum Genre {
        FANTASY, BIOGRAPHY, POEM, DRAMA, SATIRE;
    }

    private static final DateAdapter DATE_ADAPTER = new DateAdapter();
    private static final ColumnAdapter<Genre> GENRE_ADAPTER = EnumColumnAdapter.create(Genre.class);

    public static final Factory<Book> FACTORY = new Factory<>(AutoValue_Book::new, DATE_ADAPTER, GENRE_ADAPTER);

    public static final RowMapper<ForAuthor> FOR_AUTHOR_MAPPER =
            FACTORY.for_authorMapper(AutoValue_Book_ForAuthor::new, Author.FACTORY);

    @AutoValue public static abstract class ForAuthor implements For_authorModel<Book, Author> { }
}
