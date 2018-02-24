package model.myview.com.myviewmodel


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.pressKey
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.hasDescendant
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText

import org.hamcrest.CoreMatchers.not
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

import android.arch.lifecycle.MutableLiveData
import android.support.annotation.NonNull
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.KeyEvent

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by tskim on 2018. 2. 25..
 */
@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    @get:Rule
    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java, true, true)
    @get:Rule
    val executorRule = TaskExecutorWithIdlingResourceRule()

    lateinit var subject: MainFragment

    lateinit var viewModel: MyViewModel

    @Before
    fun setUp() {
        viewModel = MyViewModel()
        subject = MainFragment()
        subject.viewModelFactory = viewFactoryCreate(viewModel)
        activityRule.activity.setFragment(subject)
    }

    @Test
    fun test() {
        onView(withId(R.id.input)).perform(typeText("123bc"))
        onView(withId(R.id.digitCount)).check(matches(withText(3)))
        onView(withId(R.id.textCount)).check(matches(withText(2)))
    }
}