package com.web.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lijichen
 * @date 2021/1/12 - 15:21
 */
@RestController
public class TestParamController {

    /**
     *
     * @param id : Rest风格对应的{id}的接收
     * @param ownerName : Rest风格对应的{ownerName}的接收
     * @param all ： 如果时一个Map，且是一个Map<String,String> 泛型必须是两个String类型，则会自动封装进map
     *
     * @param userAgent : 获取单个请求头
     * @param allHeader ： 获取所有请求头信息
     *
     * @param userName : 获取单个请求(非必须)
     * @param inters ： 获取所有相同请求信息(非必须)
     * @param params ： 获取所有请求的参数
     *
     * @param SESSDATA : 获取cookie的名称(非必须)
     * @param cookie ： 获取cookie和本身的详细信息(非必须)
     * @return
     */
    @GetMapping("/dog/{id}/owner/{ownerName}")
    public Object testPathVariable(@PathVariable("id") Integer id,
                                   @PathVariable("ownerName") String ownerName,
                                   @PathVariable Map<String,String> all,

                                   @RequestHeader("User-Agent") String userAgent,
                                   @RequestHeader Map<String ,String> allHeader,

                                   @RequestParam(value = "userName", required = false) String userName,
                                   @RequestParam(value = "inters",required = false) List<String> inters,
                                   @RequestParam Map<String,String> params,

                                   @CookieValue(value = "SESSDATA",required = false) String SESSDATA,
                                   @CookieValue(value = "SESSDATA",required = false) Cookie cookie) {
        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("id",id);
//        hashMap.put("ownerName",ownerName);
//        hashMap.put("all",all);
//        hashMap.put("userAgent",userAgent);
//        hashMap.put("allHeader",allHeader);

//        hashMap.put("userName",userName);
//        hashMap.put("inters",inters);
//        hashMap.put("params",params);

        hashMap.put("SESSDATA",SESSDATA);
        hashMap.put("cookie",cookie);
        return hashMap;
    }

    /**
     * @param content ： 请求体的数据
     * @return
     */
    @PostMapping("/testRequestBody")
    public Object testRequestBody(@RequestBody String content){

        return content;
    }
}
