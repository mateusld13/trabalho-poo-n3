package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;

import com.apicomsqlite.poo.enity.Time;
import com.apicomsqlite.poo.service.TimeService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class TimeController {

    @Autowired
    private TimeService timeService;

    @RequestMapping(value = "time", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createTime", method = RequestMethod.POST)
    public String createTime(@RequestBody Time time) {
        return timeService.createTime(time);
    }

    @RequestMapping(value = "readTime", method = RequestMethod.GET)
    public List<Time> readTimes() {
        return timeService.readTime();
    }

    @RequestMapping(value = "updateTime", method = RequestMethod.PUT)
    public String updateTime(@RequestBody Time time) {
        return timeService.updateTime(time);
    }

    @RequestMapping(value = "deleteTime", method = RequestMethod.DELETE)
    public String deleteTime(@RequestBody Time time) {
        return timeService.deleteTime(time);
    }
}
