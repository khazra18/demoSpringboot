package com.example.demoproject.Configuration;


import com.example.demoproject.Utils.Circle;
import com.example.demoproject.Utils.Rectangle;
import com.example.demoproject.Utils.Shape;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public Shape getCircle(){
        return new Circle();
    }

    @Bean
    public Shape getRectangle(){
        return new Rectangle();
    }

}
