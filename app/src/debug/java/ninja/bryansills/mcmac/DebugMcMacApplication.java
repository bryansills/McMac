package ninja.bryansills.mcmac;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class DebugMcMacApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initStetho();
    }

    private void initStetho() {
        Stetho.initialize(Stetho.newInitializerBuilder(getApplicationContext())
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(getApplicationContext()))
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .build());
    }
}
