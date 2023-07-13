package com.example.demoproject.Controller;

import com.example.demoproject.Configuration.ConfigProperties;
import com.example.demoproject.Utils.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo/v1/")
public class DemoController {

    @Autowired
    private ConfigProperties properties;

    @Autowired
    @Qualifier("getRectangle")
    private Shape shape;

    @GetMapping("demo")
    public List<String> getDemoData(){
        return properties.getNames();
    }

    @GetMapping("checkBeans")
    public String getCheckBeans(){
        return shape.draw();
    }
}
