package com.example.reynaldioktino.tugasbesar;
import com.example.reynaldioktino.tugasbesar.AppPendakian.ModelPendakian;
import com.example.reynaldioktino.tugasbesar.AppPendakian.PendakianDao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ModelPendakian.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PendakianDao pendakianDao();
}
