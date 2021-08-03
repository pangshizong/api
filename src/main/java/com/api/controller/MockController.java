package com.api.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@Controller()
public class MockController {

    @RequestMapping("/unchanged")
    @ResponseBody
    public String Unchanged(@RequestBody String jsonstr){
        return jsonstr;
    }

    @RequestMapping("/unchange-addother")
    @ResponseBody
    public String RandomChanged(@RequestBody String jsonstr){
        // json array
        if(jsonstr.startsWith("[")){
            JSONArray jarray = JSONObject.parseArray(jsonstr);
//            for(Object j : jarray){
//                ((JSONObject)j).put("LocalDate","LocalDate.now().toString()");
//            }
            return jarray.toJSONString();


        }else if(jsonstr.startsWith("{")){
            JSONObject jo = JSONObject.parseObject(jsonstr);
            return jo.toJSONString();
        }
        return "Wrong with Request Body";
    }
}
