package model.myview.com.myviewmodel

import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import javax.security.auth.Subject

/**
 * Created by tskim on 2018. 2. 24..
 */
class CountObservableTest {
    lateinit var subject: CountObservable

    @Before
    fun setUp() {
        subject = CountObservable()
    }

    @Test
    fun aa() {
        subject.input = "1b1b"
        Assert.assertEquals(subject.digitCount, 2)
    }
}