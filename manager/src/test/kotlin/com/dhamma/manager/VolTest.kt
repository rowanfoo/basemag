package com.dhamma.manager

import com.google.gson.JsonObject
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
class VolTest {


    @Autowired
    lateinit var volmanager: VolManager

    //    --------------process1----{"time":"60","volumex":"3","sector":"300"}-------
    @Test
    fun vol() {
        var content = JsonObject()
        content.addProperty("time", "60")
        content.addProperty("volumex", 3)
        volmanager.today(content)

    }
}

