package com.tochapps.ceibatestapp.view

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.schibsted.spain.barista.assertion.BaristaRecyclerViewAssertions
import com.tochapps.ceibatestapp.R
import com.tochapps.ceibatestapp.common.USER_ID
import com.tochapps.ceibatestapp.ui.flow.user.post.PostActivity
import com.tochapps.ceibatestapp.utils.CONNECTION_TIME
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PostActivityTest {

    private val intent = Intent(ApplicationProvider.getApplicationContext(), PostActivity::class.java)
        .putExtra(USER_ID, 1)

    @get:Rule
    val rule = ActivityScenarioRule<PostActivity>(intent)

    @Test
    fun checkIfMainActivityHaveData(){

        Thread.sleep(CONNECTION_TIME) //TIME TO GET REMOTE DATA

        BaristaRecyclerViewAssertions.assertRecyclerViewItemCount(
            R.id.recyclerViewPostsResults,
            10
        )

    }
}