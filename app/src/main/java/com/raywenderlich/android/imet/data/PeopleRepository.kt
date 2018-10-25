/*
 *
 *  * Copyright (c) 2018 Razeware LLC
 *  *
 *
 *
 *
 */

package com.raywenderlich.android.imet.data

import android.app.Application
import android.arch.lifecycle.LiveData
import com.raywenderlich.android.imet.data.db.PeopleDao
import com.raywenderlich.android.imet.data.db.PeopleDatabase
import com.raywenderlich.android.imet.data.model.People

class PeopleRepository(application: Application) {

  private val peopleDao: PeopleDao

  init {
    val peopleDatabase = PeopleDatabase.getInstance(application)
    peopleDao = peopleDatabase.peopleDao()
  }

  /*
  fun getAllPeople(): List<People> {
    return peopleDao.getAll()
  }
  */

  fun getAllPeople(): LiveData<List<People>> {
    return peopleDao.getAll()
  }

  fun insertPeople(people: People) {
    peopleDao.insert(people)
  }

  /*
  fun findPeople(id: Int): People {
    return peopleDao.find(id)
  }*/

  fun findPeople(id: Int): LiveData<People> {
    return peopleDao.find(id)
  }

  fun findPeople(name: String): LiveData<List<People>> {
    return peopleDao.findBy(name)
  }



  /*
  /**
   * Returns the list of all people in reverse order (latest on top)
   */
  fun getAllPeople(): List<People> {
    val allPeople = PeopleInfoProvider.peopleList
    return allPeople.reversed()
  }

  /**
   * Adds a new people info on peopleList
   */
  fun insertPeople(people: People) {
    PeopleInfoProvider.peopleList.add(people)
  }

  /**
   * Finds people with specific id
   */
  fun findPeople(id: Int): People? {
    for (people in PeopleInfoProvider.peopleList) {
      if (people.id == id) {
        return people
      }
    }
    return null
  }

  /**
   * Finds people with similar name
   */
  fun searchPeople(name: String): List<People> {
    var peoples = mutableListOf<People>()
    for (people in PeopleInfoProvider.peopleList) {
      if (people.name.toLowerCase().contains(name.toLowerCase())) {
        peoples.add(people)
      }
    }
    return peoples
  }
  */

}
