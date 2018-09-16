package com.example.demo.controller;

import com.example.demo.biz.Save2TxtBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Controller
public class Save2TxtController {
    @PostMapping("save2Txt")
    public String save2Txt(HttpServletRequest request){
        Map map = request.getParameterMap();
//        System.out.println("test text value = " + textValue);
        Set set = map.entrySet();
        String[] temp = (String[]) map.get("textValue");
        System.out.println("test value = " + temp[0]);
        Save2TxtBiz.save(temp[0],"hehe.txt");
        return "test";
    }

    @RequestMapping("noteBook")
    public String redirectNoteBookPage(){
        return "noteBook";
    }
}
