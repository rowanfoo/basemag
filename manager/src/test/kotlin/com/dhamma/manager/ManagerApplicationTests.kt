package com.dhamma.manager

import com.dhamma.ignitedata.manager.RSIServiceManager
import com.google.gson.JsonObject
import org.apache.ignite.IgniteCache
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@SpringBootTest
@RunWith(SpringRunner::class)
class ManagerApplicationTests {


    @Autowired
    lateinit var rsi: RSIServiceManager
    @Autowired
    lateinit var volmanager: VolManager



//

    @Test
    fun contextLoads() {


        var content = JsonObject()
        content.addProperty("time", 14)
        content.addProperty("offset", 0)

        var cache: IgniteCache<String, Pair<Double, String>> = rsi.getCache(content)

    }


    @Test
    fun contextLoadsMore() {

        var no = 3

        var map = mutableMapOf<String, Pair<Double, String>>()

        for (i in 0..no) {

            var content = JsonObject()
            content.addProperty("time", 14)
            content.addProperty("offset", i)
            var cache: IgniteCache<String, Pair<Double, String>> = rsi.getCache(content)


//            cache.getAll().forEach{
//
//                it.key
//                it.value
//
//            }
            cache.iterator().forEach {
                map[it.key] = it.value
            }


        }

//        Observable.range(0, no)
//                .map {
//                    var content = JsonObject()
//                    content.addProperty("time", 14)
//                    content.addProperty("offset", i)
//                    content
//                }
//                .map {
//                    rsi.getCache(it)
//                }
//                .map {
//
//                }.collectInto( )


        println("----------------------------------------------------------------------------------")
        map.entries.forEach {
            println("-------${it.key}-------${it.value}***")

        }
//        val map2: Map<String, Int> = list.collectTo(HashMap(), { accumulator, item ->
//            accumulator.put(item.first, item.second) })

    }


    @Test
    fun mytest() {
//        println("-----test----")
//        for (i in 0..0) {
//            println("-----$i----")
//        }

//        Observable.range(0, 0)
//                .map {
//
//                    println("-----$it---")
//                }
//
//
//                .subscribe {
//                    println("---resutl --$it---")
//
//
//                }
        var map = mutableMapOf<String, Pair<Double, String>>()

//        Observable.range(0, 1)
//                .map {
//                    var content = JsonObject()
//                    content.addProperty("time", 14)
//                    content.addProperty("offset", it)
//                    content
//                }
//                .map {
//                    rsi.getCache(it)
//                }
//                .subscribe {
//                    it.iterator().forEach {
//
//                        map.put(it.key, it.value)
//                    }
//                }
//
//        println("------------------------")
//        println(map)


//        Observable.range(0, 10)
//                .subscribe {
//                    println("---$it---")
//
//                }


//
//
//
//                }


//        var list2 = listOf("a", "b", "c", "d")


//        val collect: String = list2.stream().collect({ StringBuilder() },
//                { res, elem ->
//
//                    println("ACCUMULATE $res  ---  $elem")
//                    res.append(" ").append(elem)
//                },
//                { res1, res2 ->
//                    println("NEWS----$res1")
//                    println("COMBINE res1=$res1, res2=$res2")
//                    res1.append(res2.toString())
//                }).toString()
//
//
//        println("TOTAL----$collect")


    }


//    --------------process1----{"time":"60","volumex":"3","sector":"300"}-------
@Test
fun vol() {


            var content = JsonObject()
        content.addProperty("time", "60")
        content.addProperty("volumex", 3)
            volmanager.today(content)

}


}

