package com.example.demoproject.Utils;

import org.springframework.stereotype.Component;

public class Rectangle implements Shape{
    @Override
    public String draw() {
        return "Rectangle";
    }
}
