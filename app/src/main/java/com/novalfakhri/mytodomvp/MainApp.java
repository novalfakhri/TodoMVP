package com.novalfakhri.mytodomvp;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.novalfakhri.mytodomvp.database.entity.DaoMaster;
import com.novalfakhri.mytodomvp.database.entity.DaoSession;

/**
 * Created by Toshiba on 10/4/2017.
 */

public class MainApp extends Application {
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        daoSession = new DaoMaster(
                new DaoMaster.DevOpenHelper(this, "todo_mvp.db").getWritableDatabase())
        .newSession();

        Stetho.initializeWithDefaults(this);
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
