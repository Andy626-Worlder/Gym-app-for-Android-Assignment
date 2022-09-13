package com.example.apple.gym;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.apple.gym.R;

import java.sql.ResultSet;

//默认 Activity 继承他
public class VipLoginActivity extends Activity {
    private Button btn_login;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vip_login);

        //初始化
//        btn_login=(Button)findViewById(R.id.btn_login);
//
//        //给btn_login添加监听器
//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                Intent intent=new Intent(VipLoginActivity.this,VipMainActivity.class);
////                //intent.putExtra("data","admin");//intent带数据
////                startActivity(intent);
//            }
//        });
    }

    /**
     * query 查询
     * 本质上跟VipAddActivity里的 insert 差不多，只不过是 writeable 变成 readable
     * @param view
     */
    public void query(View view) {
        EditText username = findViewById(R.id.et_username);

        EditText password = findViewById(R.id.et_password);
        String Usrname = username.getText().toString().trim();
        String Usrpassword = password.getText().toString().trim();
        SQLiteOpenHelper helper = GymSQLiteOpenHelper.getInstance(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        while (db.isOpen()){//数据库打开成功
            Cursor cursor = db.rawQuery("select * from Vip",null); // raw查询 + 返回游标（向下

//            String sql="select * from Vip where VipName ="+"'"+Usrname+"'"+"and VipPassword"+Usrpassword+"''"; // raw查询 + 返回游标（向下
//            ResultSet rsResultSet = db.executeQuery(sql);
            //用cursor 遍历数据
            int i=0;
            while (cursor.moveToNext()) {
//                int _VipId = cursor.getInt(0);
//                这是直接写死为 0

                // 更合规 这是返回一个值 它为 0 （如果GymSQLiteOpenHelper 里的表的primary key 变化，就会出错
                int _VipId = cursor.getInt(cursor.getColumnIndex("_VipId"));
                String usrname = cursor.getString(cursor.getColumnIndex("VipName"));
                String usrpassword = cursor.getString(cursor.getColumnIndex("VipPassword"));

                    if(Usrname.equals(usrname)){
                        if(Usrpassword.equals(usrpassword)){
                            startActivity(new Intent(this,VipMainActivity.class));

                        }else {
                        //应该是布局文件有问题
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setIcon(R.mipmap.ic_launcher)
                                .setTitle("请注意")
                                .setMessage("用户名不存在")
                                .create()
                                .show();
                        break;
                        }

                    }
                        i++;

                }
            if(i==cursor.getCount()){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("请注意")
                        .setMessage("密码错误")
                        .create()
                        .show();}

            cursor.close();
            db.close();
//                Log.d("Andy","query:_VipId:" + _VipId + "usrname:" + usrname + "usrpassword" + usrpassword);
            }
            //一定记得关闭cursor + database

        }


    public void toMusic(View view) {
        startActivity(new Intent(this,Music.class));
    }

    public void toTrueMusic(View view) {
        startActivity(new Intent(this,TrueMusic.class));
    }

////回主页面去！ 写错位置了
//    public void toMainActivity(View view) {
//        startActivity(new Intent(this,MainActivity.class));
//    }
}
