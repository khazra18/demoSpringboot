package com.example.demoproject.Controller;

import com.example.demoproject.Configuration.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private ConfigProperties properties;

    @GetMapping("/demo")
    public List<String> getDemoData(){
        return properties.getNames();
    }

}
