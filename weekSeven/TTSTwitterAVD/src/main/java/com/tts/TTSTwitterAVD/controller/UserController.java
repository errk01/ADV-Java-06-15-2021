package com.tts.TTSTwitterAVD.controller;

import com.tts.TTSTwitterAVD.model.Tweet;
import com.tts.TTSTwitterAVD.model.User;
import com.tts.TTSTwitterAVD.service.TweetService;
import com.tts.TTSTwitterAVD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TweetService tweetService;

    @GetMapping(value = "/users/{username}")
    public String getUser(@PathVariable(value="username") String username,
                          Model model){

    }

    @GetMapping(value = "/users")
    public String getUsers(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        SetTweetCounts(users, model);
        return "users";
    }

    public void SetTweetCounts(List<User> users, Model model){
        HashMap<String, Integer> tweetCounts = new HashMap<>();
        for(User user:users){
            List<Tweet> tweets = tweetService.findAllByUser(user);
            tweetCounts.put(user.getUsername(), tweets.size());
        }
        model.addAttribute("tweetCounts", tweetCounts);
    }


}
