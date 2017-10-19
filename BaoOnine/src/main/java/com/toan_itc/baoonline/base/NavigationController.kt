/*
package com.toan_itc.baoonline.base

import android.support.v4.app.FragmentManager

import com.toan_itc.baoonline.MainActivity
import com.toan_itc.baoonline.R

import javax.inject.Inject

class NavigationController
@Inject
constructor(mainActivity: MainActivity) {
    private val containerId: Int
    private val fragmentManager: FragmentManager

    init {
        this.containerId = R.id.container
        this.fragmentManager = mainActivity.supportFragmentManager
    }

   */
/* fun navigateToSearch() {
        val searchFragment = SearchFragment()
        fragmentManager.beginTransaction()
                .replace(containerId, searchFragment)
                .commitAllowingStateLoss()
    }

    fun navigateToRepo(owner: String, name: String) {
        val fragment = RepoFragment.create(owner, name)
        val tag = "repo/$owner/$name"
        fragmentManager.beginTransaction()
                .replace(containerId, fragment, tag)
                .addToBackStack(null)
                .commitAllowingStateLoss()
    }

    fun navigateToUser(login: String) {
        val tag = "user" + "/" + login
        val userFragment = UserFragment.create(login)
        fragmentManager.beginTransaction()
                .replace(containerId, userFragment, tag)
                .addToBackStack(null)
                .commitAllowingStateLoss()
    }*//*

}
*/
