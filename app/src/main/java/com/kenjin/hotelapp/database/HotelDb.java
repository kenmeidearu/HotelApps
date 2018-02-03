package com.kenjin.hotelapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kenjin.hotelapp.model.Pesanan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenjin on 5/27/2016.
 */
public class HotelDb extends SQLiteOpenHelper
{
    private static final String		DB_NAME		= "hotel";
    private static final int		DB_VERSION	= 1;

    private static HotelDb		dbInstance;
    private static SQLiteDatabase db;

    private static final String		TB_PESANAN	= "tb_pesanan";


    interface COLUMN
    {
        String	id		= "_id";
        String	nama	= "nama";
        String	nomor	= "nomor";
        String	email	= "email";
        String  lamaInap ="lamainap";
    }


    private static final String	SQL_CREATE_PESANAN	= "CREATE TABLE IF NOT EXISTS "
            + TB_PESANAN
            + "( "
            + COLUMN.id
            + " integer primary key autoincrement not null, "
            + COLUMN.nama
            + " text, "
            + COLUMN.email
            + " text, "
            + COLUMN.lamaInap
            + " text, "
            + COLUMN.nomor
            + " text)";


    private HotelDb(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static HotelDb getInstance(Context context)
    {
        if (dbInstance == null)
        {
            dbInstance = new HotelDb(context);
            db = dbInstance.getWritableDatabase();
        }
        return dbInstance;
    }

    @Override
    public synchronized void close()
    {
        super.close();
        if (dbInstance != null)
            dbInstance.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // TODO Auto-generated method stub
        db.execSQL(SQL_CREATE_PESANAN);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TB_PESANAN);
        onCreate(db);
    }

    public boolean addPesanan(Pesanan data)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN.nama, data.getNama());
        values.put(COLUMN.email, data.getEmail());
        values.put(COLUMN.nomor, data.getNumber());
        values.put(COLUMN.lamaInap,data.getLamainap());
        return (db.insert(TB_PESANAN, null, values)) != -1;
    }

    public List<Pesanan> getAllPesanan()
    {
        List<Pesanan> listPesanan = new ArrayList<Pesanan>();
        Cursor cursor = db.query(TB_PESANAN, new String[] { COLUMN.id,
                        COLUMN.nama, COLUMN.nomor, COLUMN.email,COLUMN.lamaInap },
                        null,null, null,
                        null, COLUMN.nama);
        cursor.moveToFirst();
        do
        {
            listPesanan
                    .add(new Pesanan(cursor.getInt(cursor
                            .getColumnIndexOrThrow(COLUMN.id)), cursor
                            .getString(cursor
                                    .getColumnIndexOrThrow(COLUMN.nama)),
                            cursor.getString(cursor
                                    .getColumnIndexOrThrow(COLUMN.nomor)),
                            cursor.getString(cursor
                                    .getColumnIndexOrThrow(COLUMN.email)),
                            cursor.getString(cursor
                                    .getColumnIndexOrThrow(COLUMN.lamaInap))
                        ));
        } while (cursor.moveToNext());
        return listPesanan;
    }

    public boolean isContactHasData()
    {
        Cursor cursor = db.query(TB_PESANAN, new String[] { COLUMN.id }, null,
                null, null, null, null);
        return (cursor.getCount() > 0) ? true : false;
    }



    public boolean editPesanan(Pesanan pesanan)
    {
        ContentValues values = new ContentValues();

        values.put(COLUMN.nama, pesanan.getNama());
        values.put(COLUMN.email, pesanan.getEmail());
        values.put(COLUMN.nomor, pesanan.getNumber());
        values.put(COLUMN.lamaInap,pesanan.getLamainap());

        return ((db.update(TB_PESANAN, values, COLUMN.id + "=?",
                new String[] { String.valueOf(pesanan.getId()) })) == 1) ? true
                : false;
    }

    public void deletePesanan(int id)
    {
        db.delete(TB_PESANAN, COLUMN.id + "=? ",
                new String[] { String.valueOf(id) });
    }
}
