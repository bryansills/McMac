package ninja.bryansills.mcmac.database.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.sqldelight.ColumnAdapter;
import com.squareup.sqldelight.EnumColumnAdapter;
import com.squareup.sqldelight.RowMapper;

import java.util.Calendar;

import ninja.bryansills.mcmac.database.adapter.DateAdapter;

@AutoValue
public abstract class Book implements BookModel {

    public enum Genre {
        FANTASY, BIOGRAPHY, POEM, DRAMA, SATIRE
    }

    private static final DateAdapter DATE_ADAPTER = new DateAdapter();
    private static final ColumnAdapter<Genre, String> GENRE_ADAPTER = EnumColumnAdapter.create(Genre.class);

    public static final Factory<Book> FACTORY = new Factory<>(new Creator<Book>() {
        @Override
        public Book create(long _id, @NonNull String isbn, @NonNull String title, @Nullable Long author, @NonNull Calendar release_year, @NonNull Genre genre) {
            return new AutoValue_Book(_id, isbn, title, author, release_year, genre);
        }
    }, DATE_ADAPTER, GENRE_ADAPTER);

    public static final RowMapper<ForAuthor> FOR_AUTHOR_MAPPER =
            FACTORY.for_authorMapper(new For_authorCreator<Book, Author, ForAuthor>() {
                @Override
                public ForAuthor create(@NonNull Book book, @NonNull Author author) {
                    return new AutoValue_Book_ForAuthor(book, author);
                }
            }, Author.FACTORY);

    @AutoValue public static abstract class ForAuthor implements For_authorModel<Book, Author> { }
}
