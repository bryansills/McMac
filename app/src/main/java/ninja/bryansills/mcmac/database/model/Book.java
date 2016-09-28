package ninja.bryansills.mcmac.database.model;

import com.google.auto.value.AutoValue;

import ninja.bryansills.mcmac.database.adapter.DateAdapter;

@AutoValue
public abstract class Book implements BookModel {

    private final static DateAdapter DATE_ADAPTER = new DateAdapter();

    public static final Factory<Book> FACTORY = new Factory<>(AutoValue_Book::new, DATE_ADAPTER);
}
