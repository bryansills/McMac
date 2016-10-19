package ninja.bryansills.mcmac.database.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.Calendar;

import ninja.bryansills.mcmac.database.adapter.DateAdapter;

@AutoValue
public abstract class Author implements AuthorModel {

    private final static DateAdapter DATE_ADAPTER = new DateAdapter();

    public static final Factory<Author> FACTORY = new Factory<>(new Creator<Author>() {
        @Override
        public Author create(@Nullable Long _id, @NonNull String name, @NonNull Calendar birth_year) {
            return new AutoValue_Author(_id, name, birth_year);
        }
    }, DATE_ADAPTER);

    public static final Mapper<Author> MAPPER = FACTORY.select_allMapper();
}
