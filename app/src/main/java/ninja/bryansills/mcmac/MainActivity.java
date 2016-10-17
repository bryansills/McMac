package ninja.bryansills.mcmac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ninja.bryansills.mcmac.database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper helper = DatabaseHelper.getInstance(this);
    }
}
