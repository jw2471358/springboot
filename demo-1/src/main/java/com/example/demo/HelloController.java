package com.example.demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;

@Controller
public class HelloController {
	@RequestMapping("/")
	public void hello(HttpServletResponse respose) throws IOException {
		respose.getWriter().print("Hello World!!!!!");
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("/welcome-thymeleaf")
	public String welcome(Model model) throws Exception {
	    model.addAttribute("greeting", "Hello Thymeleaf!");
	    return "thymeleaf/welcome";
	}
	
	@ResponseBody
    @RequestMapping("/json")
    public <T> Map<String, Object> jsonReturnSample(@RequestBody JSONResponse<T> jsonRes){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "111");
        map.put("age", "2222");
        map.put("data", jsonRes.getData());
        
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(map);
        
        JSONObject dataObj = new JSONObject(map);
        JSONObject data = (JSONObject) dataObj.get("data");
        log(data.get("name"));
        
        JSONObject ll = new JSONObject(list);
        log(ll);
		log("\nMethod-2: Using new JSONObject() ==> " + dataObj);
        
        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        System.out.println("before sleep="+format1.format(time));
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        time = new Date();
        System.out.println("after sleep ="+format1.format(time));
        return map;
    }
	
	private static void log(Object print) {
		System.out.println(print);
 
	}
}