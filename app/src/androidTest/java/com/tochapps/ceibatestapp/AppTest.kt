package com.tochapps.ceibatestapp

import com.tochapps.ceibatestapp.view.MainActivityTest
import com.tochapps.ceibatestapp.view.PostActivityTest

import org.junit.runner.RunWith

import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(MainActivityTest::class,
    PostActivityTest::class)
class AppTest