package com.rami.all1one;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseUtils {















   // BASE DE DATOS SQLITE
    public static class Sqlite extends SQLiteOpenHelper {
        public interface ISqliteCalback{
            void onCreate(SQLiteDatabase database);
            void onUpgrade(SQLiteDatabase database,int oldVersion, int newVersion);
        }

        ISqliteCalback callback;
        public static class tablaModel{
            String nombreTabla;
            String createSQL;
            String dropSQL = "drop table if exists " + nombreTabla;

            public tablaModel(String nombreTabla, String createSQL) {
                this.nombreTabla =nombreTabla;
                this.createSQL = createSQL;
            }
        }
        public static tablaModel newTabla(String nombreTabla,String createSQL){
            return new tablaModel(nombreTabla,createSQL);
        }
        private Sqlite(@Nullable Context context, @Nullable String nombreDB,ISqliteCalback callback) {
            super(context, nombreDB, null, 1);
            this.callback = callback;
        }
        public static Sqlite newInstancia(Context context, String nombreDB, ISqliteCalback callbak){
            return new Sqlite(context, nombreDB, callbak);
        };
        @Override
        public void onCreate(SQLiteDatabase db) {
            callback.onCreate(db);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                callback.onUpgrade(db, oldVersion, newVersion);
        }


        public SQLiteDatabase getDatabase(){
            return getWritableDatabase();
        }


        public void createTabla(tablaModel tablaModel) throws SQLException {
            getWritableDatabase().execSQL(tablaModel.createSQL);
        }
        public void dropTabla(tablaModel tablaModel){
            getWritableDatabase().execSQL(tablaModel.dropSQL);
        }

    }
}
