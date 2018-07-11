package org.zemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: org.zemo.controller.IndexController
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 24/11/2016 19:15
 * @Description ${TODO}
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = {"","/index"},method = RequestMethod.GET)
    public ResponseEntity<?> index(){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("msg", "hello");
        result.put("msg2", "hello");
        result.put("msgs2", "hello");

        return new ResponseEntity(result, HttpStatus.OK);
    }
}
