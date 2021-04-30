package com.xfactor.lably.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;
import com.xfactor.lably.entity.Lab;

@RestController
@RequestMapping("/lab")

public class LabController{
    ArrayList<Lab> labs = new ArrayList<>();

    @GetMapping("/getLabs")
    public ArrayList<Lab> getLabs() {
        return labs;
    }

    @PostMapping("/addLab")
    public Lab addLab(@RequestBody Lab lab) {
        String name = lab.getName();
        lab.setName(name);
        String phone=lab.getPhone();
        phone="+91-"+phone;
        lab.setPhone(phone);
        String pin=lab.getPincode();
        pin="P"+pin;
        lab.setPincode(pin);
        labs.add(lab);
        return lab;
    }
    @GetMapping("/findLab")
    @ResponseBody
    public Lab findLab(@RequestParam String name){
        int flag=0;
        for(Lab l:labs){
            if(name.equals(l.getName())==true)
                return l;
        }
        return null;
    }

}
