package com.raywenderlich.android.imet.data.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.raywenderlich.android.imet.data.model.People

/**
 * Created by LayYuan on 2018-10-25.
 */


@Dao
interface PeopleDao {

    // 1: Select All
    @Query("SELECT * FROM People ORDER BY id DESC")
    //fun getAll(): List<People>

    //Now your app can observe changes in the model with very little effort!
    fun getAll(): LiveData<List<People>>

    // 2: Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(people: People)

    // 3: Delete
    @Query("DELETE FROM People")
    fun deleteAll()

    // 4: Select by id
    @Query("SELECT * FROM People WHERE id = :id")
    fun find(id: Int): People

    //to query People by name from the database:
    @Query("SELECT * FROM People WHERE name LIKE '%' || :name || '%'")
    fun findBy(name: String): LiveData<List<People>>

}