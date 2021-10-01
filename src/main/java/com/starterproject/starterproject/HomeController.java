package com.starterproject.starterproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

//    @GetMapping("/")
//    public String homePage()
//    {
//        return "HomePage";
//    }

    @GetMapping("homepage2")
    public List<String> homePage2()
    {
        return List.of("HomePage2", "Test2");
    }
}
