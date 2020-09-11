package com.dhamma.manager

import com.dhamma.ignitedata.manager.VolumeServiceManager
import com.google.gson.JsonObject
import io.reactivex.rxjava3.core.Observable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class VolManager {

    @Autowired
    lateinit var vol: VolumeServiceManager


    fun today(content: JsonObject): Map<String, Pair<Double, String>> {
        content.addProperty("offset", 1)
        return process(content)
    }

    fun period(content: JsonObject): Map<String, Pair<Double, String>> {
        return process(content)
    }

    fun process(content: JsonObject): Map<String, Pair<Double, String>> {
        var map = mutableMapOf<String, Pair<Double, String>>()
        var no = content.get("offset").asInt + 1
        var time = content.get("time").asInt
        Observable.range(0, no)
                .map {
                    var content = JsonObject()
                    content.addProperty("offset", it)
                    content.addProperty("time", time)

                    content
                }
                .map {
                    vol.getCache(it)
                }
                .subscribe {
                    it.iterator().forEach {
                        map.put(it.key, it.value)
                    }
                }
        return map
    }

}
