package com.sample.newsapi.datarepository.offlinerepo.database;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.sample.newsapi.models.HeadLine;

import java.util.List;


@Dao
public interface HeadLinesListDAO {

    @Query("SELECT * from headline_table")
    LiveData<List<HeadLine>> fetchPlacesFromDB();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void batchInsert(HeadLine... headLines);

    @Query("DELETE FROM headline_table")
    void deleteAll();
}
