package com.tts.TTSTwitterAVD.service;

import com.tts.TTSTwitterAVD.model.Tweet;
import com.tts.TTSTwitterAVD.model.User;
import com.tts.TTSTwitterAVD.repository.TweetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {

    @Autowired
    private TweetRepo tweetRepo;

    public List<Tweet> findAll(){
        List<Tweet> tweets = tweetRepo.findAllByOrderByCreatedAtDesc();
        return tweets;
    }

    public List<Tweet> findAllByUser(User user){
        List<Tweet> tweets = tweetRepo.findAllByUserOrderByCreatedAtDesc(user);
        return tweets;
    }
    public List<Tweet> findAllByUsers(List<User> users){
        List<Tweet> tweets = tweetRepo.findAllByUserInOrderByCreatedAtDesc(users);
        return tweets;
    }

    public void save(Tweet tweet){
        tweetRepo.save(tweet);
    }



}
