/*
 *
 *  * Copyright (c) 2018 Razeware LLC
 *  *
 *
 */

package com.raywenderlich.android.imet.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.raywenderlich.android.imet.R

class MainActivity : AppCompatActivity() {

  //1
  private lateinit var navigationController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main)

    //2
    navigationController = findNavController(R.id.navigationHostFragment)

    NavigationUI.setupActionBarWithNavController(this, navigationController)
  }

  //3
  override fun onSupportNavigateUp() = navigationController.navigateUp()
}


/*
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

}
*/
