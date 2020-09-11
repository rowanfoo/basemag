package com.dhamma.manager

import com.dhamma.ignitedata.manager.RSIServiceManager
import com.google.gson.JsonObject
import io.reactivex.rxjava3.core.Observable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RSIManager {


    @Autowired
    lateinit var rsi: RSIServiceManager


    fun today(content: JsonObject): Map<String, Pair<Double, String>> {
//        var content = JsonObject()
//        content.addProperty("time", 14)
        content.addProperty("offset", 1)

//        var cache: IgniteCache<String, Pair<Double, String>> = rsi.getCache(content)
//        return toMap(cache);
        println("-----RSIServiceManager-today----------${content}---------------------")
        println("------today----------${content.get("time")}---------------------")
        return process(content)

    }

    fun period(content: JsonObject): Map<String, Pair<Double, String>> {
        return process(content)
    }

//
//    fun period(content: JsonObject) {
//
//        var no = content.get("offset")
//
//        var map = mutableMapOf<String, Pair<Double, String>>()
//
//        for (i in 0..no) {
//
//            var data = JsonObject()
//            data.addProperty("time", 14)
//            data.addProperty("offset", i)
//            var cache: IgniteCache<String, Pair<Double, String>> = rsi.getCache(data)
//
////            cache.getAll().forEach{
////
////                it.key
////                it.value
////
////            }
//            cache.iterator().forEach {
//                map[it.key] = it.value
//            }
//
//
//        }
//        println("----------------------------------------------------------------------------------")
//        map.entries.forEach {
//            println("-------${it.key}-------${it.value}***")
//
//        }
//
//
//    }


    fun process(content: JsonObject): Map<String, Pair<Double, String>> {
        var map = mutableMapOf<String, Pair<Double, String>>()
        var no = content.get("offset").asInt + 1
        var time = content.get("time").asInt
        println("------process----------${content.get("time")}---------------------")
        println("-----RSIServiceManager-process----------${content}---------------------")

        Observable.range(0, no)
                .map {
                    var content = JsonObject()
                    content.addProperty("offset", it)
                    content.addProperty("time", time)

                    content
                }
                .map {
                    println("-----RSIServiceManager-MAP----------${it}---------------------")
                    rsi.getCache(it)
                }
                .subscribe {
                    it.iterator().forEach {
                        map.put(it.key, it.value)
                    }
                }

//        println("------------------------")
//        println(map)
        return map

    }


//    private fun toMap(cache: IgniteCache<String, Pair<Double, String>>): Map<String, Pair<Double, String>> {
//
//        var map = mutableMapOf<String, Pair<Double, String>>()
//
//        cache.iterator().forEach {
//            map[it.key] = it.value
//        }
//
//        return map
//
//    }


}



