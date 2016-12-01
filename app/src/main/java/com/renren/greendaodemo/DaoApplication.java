package com.renren.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.renren.greendaodemo.bean.greendao.DaoMaster;
import com.renren.greendaodemo.bean.greendao.DaoSession;
import com.renren.greendaodemo.bean.greendao.MyOpenHelper;

/**
 * Created by Administrator on 2016/12/1.
 */

public class DaoApplication extends Application {

    private static DaoApplication mInstance;
    private DaoMaster.DevOpenHelper mOpenHelper;
    private SQLiteDatabase mDatabase;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;


    private static final String DEFAULT_DB_NAME = "notes-db";

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        setDatabase();
    }

    private void setDatabase() {

        // 通过DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为greenDAO 已经帮你做了。
        // 注意：默认的DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        //mDatabase = mOpenHelper.getWritableDatabase();
        mDaoMaster = getDaoMaster();
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoMaster getDaoMaster() {
        if (mDaoMaster == null) {
            DaoMaster.OpenHelper helper = new MyOpenHelper(this,DEFAULT_DB_NAME);
            mDaoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return mDaoMaster;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDatabase() {
        return mDatabase;
    }

    public static DaoApplication getmInstance() {
        return mInstance;
    }


}
