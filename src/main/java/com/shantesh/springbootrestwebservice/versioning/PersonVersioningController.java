package com.shantesh.springbootrestwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Bob Marlie");

    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Charlie", "chaplin"));

    }
    @GetMapping(value = "person/param", params = "version=1")
    public PersonV1 paranV1(){
        return new PersonV1("Bob Marlie");

    }

    @GetMapping(value = "person/param", params = "version=2")
    public PersonV2 paranV2(){
        return new PersonV2(new Name("Charlie", "chaplin"));

    }
}
