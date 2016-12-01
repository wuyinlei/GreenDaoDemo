package com.renren.greendaodemo.bean.greendao;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * <p>如果是更新数据库<br>
 * 1、在build.gradle文件中修改 schemaVersion 2  的值(2是相当于之前的1做了修改)
 * </br>
 * <br>
 * 2、重写onUpgrade(Database db,int oldVersion,int newVersion)方法,在这里根据数据库的操作来升级
 * </br>
 * <br>
 * 3、重写完之后，在AppLication中重写DaoMaster的返回
 * public DaoMaster getDaoMaster() {
 * if (mDaoMaster == null) {
 * DaoMaster.OpenHelper helper = new MyOpenHelper(this,DEFAULT_DB_NAME);
 * mDaoMaster = new DaoMaster(helper.getWritableDatabase());
 * }
 * return mDaoMaster;
 * }
 * </br>
 * <br>
 * 4、最后 mDaoMaster = getDaoMaster();
 * mDaoSession = mDaoMaster.newSession();
 * </br>
 * </p>
 */

public class MyOpenHelper extends DaoMaster.OpenHelper {
    public MyOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:

                StudentDao.createTable(db, true);
                db.execSQL("ALTER TABLE 'STUDENT' ADD 'ADDRESS' TEXT;");

                break;

        }
    }
}
