package com.silence.sspaint.controller;

import com.silence.sspaint.entity.Artist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by tristan on 16/1/25.
 */
@RestController
@RequestMapping("/")
public class NavigationController {
    @RequestMapping("/")
    public ModelAndView homePage() {



        ModelAndView view = new ModelAndView("main");

        return view;
    }
@RequestMapping("dologin")
    public Artist doLogin(String loginId, String password) {
    Artist artist=new Artist();
    artist.setNickName("asdasd");
    artist.setUserName("asdasdasd");
    return  artist;
    }


    @RequestMapping(value = "doregister", method = RequestMethod.POST)
    public ModelAndView doRegister(Artist artist, BindingResult result) {
        System.out.println(result.hasErrors());


        return new ModelAndView("redirect:/");
    }
}

