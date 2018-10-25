/*
 *
 *  * Copyright (c) 2018 Razeware LLC
 *
 *
 *
 *
 */

package com.raywenderlich.android.imet.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class People(
    var name: String = "",
    var metAt: String = "",
    var contact: String = "",
    var email: String = "",
    var facebook: String = "",
    var twitter: String = "",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
