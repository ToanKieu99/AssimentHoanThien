package com.example.admin.assimenthoanthien.DatabaseManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.assimenthoanthien.Fragment.Fragment_khoan_thu;

public class DatabaseManager {
    private static final String DB_NAME = "QLTC";
    private static final String TB_KHOAN_THU = "KhoanThu";
    private static final String TB_KHOAN_CHI = "KhoanChi";
    private static final String TB_LOAI_THU = "LoaiThu";
    private static final String TB_LOAI_CHI = "LoạiChi";
    private static final int DB_VERSTION = 1;
    private SQLiteDatabase database;

    //Bước 4
    public DatabaseManager (Context context){
        OpenHelper helper = new OpenHelper(context);
        database = helper.getWritableDatabase();
    }


    //bước 3: các phương thức của database
    //INSERT
    public void insertKhoanThu(String ten) {
        ContentValues values = new ContentValues();
        values.put("TenKT", ten);
        database.insert(TB_KHOAN_THU, null, values);
    }

    public void insertKhoanChi(String ten) {
        ContentValues values = new ContentValues();
        values.put("TenKC", ten);
        database.insert(TB_KHOAN_CHI, null, values);
    }

    public void insertLoaiThu(String ten) {
        ContentValues values = new ContentValues();
        values.put("TenLT", ten);
        database.insert(TB_LOAI_THU, null, values);
    }

    public void insertLoaiChi(String ten) {
        ContentValues values = new ContentValues();
        values.put("TenLC", ten);
        database.insert(TB_LOAI_CHI, null, values);
    }

    //Updata
    public void updataKhoanThu(int id, String ten) {
        ContentValues values = new ContentValues();
        values.put("TenKT", ten);
        database.update(TB_KHOAN_THU, values, "_id = " + id, null);
    }

    public void updataKhoanChi(int id, String ten) {
        ContentValues values = new ContentValues();
        values.put("TenKC", ten);
        database.update(TB_KHOAN_CHI, values, "_id = " + id, null);
    }

    public void updataLoaiThu(int id, String ten) {
        ContentValues values = new ContentValues();
        values.put("TenLT", ten);
        database.update(TB_LOAI_THU, values, "_id = " + id, null);
    }

    public void updataLoaiChi(int id, String ten) {
        ContentValues values = new ContentValues();
        values.put("TenLC", ten);
        database.update(TB_LOAI_CHI, values, "_id = " + id, null);
    }

    //delete
    public void deleteKhoanThu(int id) {
        database.delete(TB_KHOAN_THU, "_id = " + id, null);
    }

    public void deleteKhoanChi(int id) {
        database.delete(TB_KHOAN_CHI, "_id = " + id, null);
    }

    public void deleteLoaiThu(int id) {
        database.delete(TB_LOAI_THU, "_id = " + id, null);
    }

    public void deleteLoaiChi(int id) {
        database.delete(TB_LOAI_CHI, "_id = " + id, null);
    }

    //SELECT
    public Cursor getKhoanThu() {
        return database.query(TB_KHOAN_THU, null, null, null, null, null, null);
    }

    public Cursor getKhoanChi() {
        return database.query(TB_KHOAN_CHI, null, null, null, null, null, null);
    }

    public Cursor getLoaiThu() {
        return database.query(TB_LOAI_THU, null, null, null, null, null, null);
    }

    public Cursor getLoaiChi() {
        return database.query(TB_LOAI_CHI, null, null, null, null, null, null);
    }


    //BƯỚC 2: tạo bảo
    public class OpenHelper extends SQLiteOpenHelper {


        public OpenHelper(Context context) {
            super(context,DB_NAME, null, DB_VERSTION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //TẠO BẢNG
            String taobangKhoanThu = "CREATE TABLE IF NOT EXISTS KhoanThu(_id INTEGER PRIMARY KEY AUTOINCREMENT,TenKT TEXT)";
            String taobangKhoanChi = "CREATE TABLE IF NOT EXISTS KhoanChi(_id INTEGER PRIMARY KEY AUTOINCREMENT,TenKC TEXT)";
            String taobangLoaiThu = "CREATE TABLE IF NOT EXISTS LoaiThu(_id INTEGER PRIMARY KEY AUTOINCREMENT,TenLT TEXT)";
            String taobangLoaiChi = "CREATE TABLE IF NOT EXISTS LoaiChi(_id INTEGER PRIMARY KEY AUTOINCREMENT,TenLC TEXT)";

            sqLiteDatabase.execSQL(taobangKhoanThu);
            sqLiteDatabase.execSQL(taobangKhoanChi);
            sqLiteDatabase.execSQL(taobangLoaiThu);
            sqLiteDatabase.execSQL(taobangLoaiChi);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            //xóa bảng
            String xoabangKhoanThu = "DROP TABLE IF EXISTS KhoanThu";
            String xoabangKhoanChi = "DROP TABLE IF EXISTS KhoanChi";
            String xoabangLoaiThu = "DROP TABLE IF EXISTS LoaiThu";
            String xoabangLoaiChi = "DROP TABLE IF EXISTS LoaiChi";
            sqLiteDatabase.execSQL(xoabangKhoanThu);
            sqLiteDatabase.execSQL(xoabangKhoanChi);
            sqLiteDatabase.execSQL(xoabangLoaiThu);
            sqLiteDatabase.execSQL(xoabangLoaiChi);

            //tạo mới
            onCreate(sqLiteDatabase);

        }
    }
}
