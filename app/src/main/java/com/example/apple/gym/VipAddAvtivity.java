package com.example.apple.gym;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.apple.gym.R;

public class VipAddAvtivity extends Activity {


// login 与 add 是一体的。
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vip_add);
//        String usrname = findViewById(R.id.et_username).toString();
//        //RadioButton usrsex = findViewById(R.id.et_sex);
//        String usrmail = findViewById(R.id.rl_email).toString();
    }

//    /**
//     * add 建立数据库
//     * vip_add.xml 的onClick的来处
//     * @param view
//     */
//    public void add(View view) {
//
//        SQLiteOpenHelper helper = GymSQLiteOpenHelper.getInstance(this);
//
//        //下面这句话创建数据库
//        SQLiteDatabase writableDatabase = helper.getWritableDatabase();
//    }

    /**
     * insert 插入数据到数据库
     * @param view
     */
    public void insert(View view) {
        EditText username = findViewById(R.id.et_username);
        EditText tel = findViewById(R.id.et_tel);
        EditText email = findViewById(R.id.et_email);
        EditText password = findViewById(R.id.et_password);

        SQLiteOpenHelper helper = GymSQLiteOpenHelper.getInstance(this);
        SQLiteDatabase db =  helper.getWritableDatabase();


        String usrname = username.getText().toString().trim();
        String usrtele = tel.getText().toString().trim();
        //System.out.println(usrname);     //RadioButton usrsex = findViewById(R.id.et_sex);
        String usrmail = email.getText().toString().trim();
        String usrpassword = password.getText().toString().trim();


        //确保数据库打开

        if(db.isOpen()){
            //插入数据
//            String sql="insert into Vip(VipName,Sex,Tel,Email,VipPassword) values('cxy','Male','153','1111@qq.com','123')";
            //String sql = "insert into Vip(VipName,Email) values(?,?)";
            if(usrname != null && usrtele != null && usrmail != null && usrpassword != null){
                ContentValues values = new ContentValues();
                values.put("VipName",usrname);
                values.put("Tel",usrtele);
                values.put("Email",usrmail);
                values.put("VipPassword",usrpassword);
                db.insert("Vip", null, values);
            }


        }
        db.close();
    }

    public void toMainActivity(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
