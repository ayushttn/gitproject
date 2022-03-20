package com.example.restfulservice2.Versioning;

import org.springframework.web.bind.annotation.GetMapping;

public class VersionController {
    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Ayush Tyagi");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Ayush" , "Tyagi"));
    }

    @GetMapping(value="/person/param",params="version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Ayush Tyagi");
    }

    @GetMapping(value="/person/param",params="version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Ayush" , "Tyagi"));
    }

    @GetMapping(value="/person/header",headers="X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Ayush Tyagi");
    }

    @GetMapping(value="/person/header",headers="X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Ayush" , "Tyagi"));
    }

    @GetMapping(value="/person/producer",produces="application/vnd.company.app-v1+json")
    public PersonV1 producerV1(){
        return new PersonV1("Ayush Tyagi");
    }

    @GetMapping(value="/person/producer",produces="application/vnd.company.app-v2+json")
    public PersonV2 producerV2(){
        return new PersonV2(new Name("Ayush" , "Tyagi"));
    }

}
