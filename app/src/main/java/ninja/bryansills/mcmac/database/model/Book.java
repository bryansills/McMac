package ninja.bryansills.mcmac.database.model;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;
import com.squareup.sqldelight.RowMapper;

import ninja.bryansills.mcmac.database.adapter.DateAdapter;

@AutoValue
public abstract class Book implements BookModel {

    private final static DateAdapter DATE_ADAPTER = new DateAdapter();

    public static final Factory<Book> FACTORY = new Factory<>(AutoValue_Book::new, DATE_ADAPTER);

    public static final RowMapper<ForAuthor> FOR_AUTHOR_MAPPER =
            FACTORY.for_authorMapper(AutoValue_Book_ForAuthor::new, Author.FACTORY);

    @AutoValue public static abstract class ForAuthor implements For_authorModel<Book, Author> { }
}
