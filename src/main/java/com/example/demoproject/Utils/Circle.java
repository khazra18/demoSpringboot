package com.example.demoproject.Utils;

import org.springframework.stereotype.Component;

public class Circle implements Shape{
    @Override
    public String draw() {
        return "Circle";
    }
}
