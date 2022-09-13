package com.example.apple.gym;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

/**
 * 工具类 单例模式（1.构造函数私有化(这里选择公开  2.对外提供函数）
 */
public class GymSQLiteOpenHelper extends SQLiteOpenHelper{
    //这个类完成所有数据库增删改查操作 SQLiteOpenHelper是android自带封装类 但是是抽象类 所以要自己写一个类（即GymSQLiteOpenHelper 来继承它

    //new
    private static SQLiteOpenHelper mInstance;
    public static synchronized SQLiteOpenHelper getInstance(Context context){
        if(mInstance == null){
            mInstance = new GymSQLiteOpenHelper(context, "gym.db", null, 1); //版本号开始一定是从1开始
        }
        return  mInstance;
    }

    public GymSQLiteOpenHelper(@Nullable Context context,@Nullable String name,@Nullable SQLiteDatabase.CursorFactory factory,int version) {
//        //创建数据库
//        super(context, "gym.db", null, 1);
        super(context,name,factory,version);
    }

    @Override
    //数据库初始化
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table Vip(_VipId integer primary key autoincrement, VipName text, Tel text, Email text, VipPassword text )";

        db.execSQL(sql);
//        //创建数据表 此函数只会使用一次
//        db.execSQL("create table Admin(" +"AdminId Integer primary key autoincrement,"
//                +"AdminLevel Integer," +"AdminUser varchar(50),"
//                +"AdminPassword varchar(50))");
//        db.execSQL("create table Vip(" +"VipId Integer primary key autoincrement,"
//                +"Level varchar(50)," +"VipName varchar(50),"
//                +"VipPassword varchar(50),"+"Sex Integer,"
//                +"Tel varchar(50)," +"Birth varchar(50),"
//                +"Email varchar(50),"+"Image varchar(50))");
//

    }

    //数据库升级
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
