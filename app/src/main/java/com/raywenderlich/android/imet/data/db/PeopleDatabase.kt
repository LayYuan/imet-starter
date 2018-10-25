package com.raywenderlich.android.imet.data.db

import android.app.Application
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.raywenderlich.android.imet.data.model.People

/**
 * Created by LayYuan on 2018-10-25.
 */


// 1
@Database(entities = [People::class], version = 1)
abstract class PeopleDatabase : RoomDatabase() {

    abstract fun peopleDao(): PeopleDao

    // 2
    companion object {
        private val lock = Any()
        private const val DB_NAME = "People.db"
        private var INSTANCE: PeopleDatabase? = null

        // 3
        fun getInstance(application: Application): PeopleDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(application,
                                    PeopleDatabase::class.java, DB_NAME)
                                    .allowMainThreadQueries()
                                    .build()
                }
                return INSTANCE!!
            }
        }


    }
}