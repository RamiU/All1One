package com.rami.all1one.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseUtils {


















    public static class Sqlite extends SQLiteOpenHelper {
        public interface ISqliteCalback{
            void onCreate(SQLiteDatabase database);
            void onUpgrade(SQLiteDatabase database,int oldVersion, int newVersion);
        }
        ISqliteCalback calback;
        class tablaModel{
            String nombreTabla;
            String createSQL;
            String dropSQL = "drop table if exists " + nombreTabla;
        }

        public Sqlite(@Nullable Context context, @Nullable String nombreDB) {
            super(context, nombreDB, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            calback.onCreate(db);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                calback.onUpgrade(db, oldVersion, newVersion);
        }
    }
}
