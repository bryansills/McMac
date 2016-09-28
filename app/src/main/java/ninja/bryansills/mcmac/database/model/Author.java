package ninja.bryansills.mcmac.database.model;

import com.google.auto.value.AutoValue;

import ninja.bryansills.mcmac.database.adapter.DateAdapter;

@AutoValue
public abstract class Author implements AuthorModel {

    private final static DateAdapter DATE_ADAPTER = new DateAdapter();

    public static final Factory<Author> FACTORY = new Factory<>(AutoValue_Author::new, DATE_ADAPTER);

    public static final Mapper<Author> MAPPER = new Mapper<>(FACTORY);
}
