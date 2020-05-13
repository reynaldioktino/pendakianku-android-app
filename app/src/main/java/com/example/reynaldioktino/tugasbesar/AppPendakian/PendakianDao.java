package com.example.reynaldioktino.tugasbesar.AppPendakian;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;
@Dao
public interface PendakianDao {

    @Query("SELECT * FROM modelpendakian")
    List<ModelPendakian> getAllUsers();

    @Insert
    void insertAll(ModelPendakian...modelspendakian);
}
