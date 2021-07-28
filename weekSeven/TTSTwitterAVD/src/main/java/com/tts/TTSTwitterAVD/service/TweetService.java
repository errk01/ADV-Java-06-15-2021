package com.tts.TTSTwitterAVD.service;

import com.tts.TTSTwitterAVD.model.Tag;
import com.tts.TTSTwitterAVD.model.Tweet;
import com.tts.TTSTwitterAVD.model.User;
import com.tts.TTSTwitterAVD.repository.TagRepo;
import com.tts.TTSTwitterAVD.repository.TweetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TweetService {

    @Autowired
    private TweetRepo tweetRepo;

    @Autowired
    private TagRepo tagRepo;

    public List<Tweet> findAll(){
        List<Tweet> tweets = tweetRepo.findAllByOrderByCreatedAtDesc();
        return formatTweets(tweets);
    }

    public List<Tweet> findAllByUser(User user){
        List<Tweet> tweets = tweetRepo.findAllByUserOrderByCreatedAtDesc(user);
        return tweets;
    }
    public List<Tweet> findAllByUsers(List<User> users){
        List<Tweet> tweets = tweetRepo.findAllByUserInOrderByCreatedAtDesc(users);
        return tweets;
    }

    public List<Tweet> findAllWithTag(String tag){
        List<Tweet> tweets = tweetRepo.findByTags_PhraseOrderByCreatedAtDesc(tag);
        return formatTweets(tweets);
    }

    public void save(Tweet tweet){
        handleTags(tweet);
        tweetRepo.save(tweet);
    }

    private void handleTags(Tweet tweet){
        List<Tag> tags = new ArrayList<>();
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(tweet.getMessage());
        while(matcher.find()){
            String phrase = matcher.group().substring(1).toLowerCase();
            Tag tag = tagRepo.findByPhrase(phrase);
            if(tag == null){
                tag = new Tag();
                tag.setPhrase(phrase);
                tagRepo.save(tag);
            }
            tags.add(tag);
        }
        tweet.setTags(tags);
    }

    private List<Tweet> formatTweets(List<Tweet> tweets){
        addTagLinks(tweets);
        shortenLinks(tweets);
        return tweets;
    }

    private void addTagLinks(List<Tweet> tweets) {
        Pattern pattern = Pattern.compile("#\\w+");

        for (Tweet tweet : tweets) {
            String message = tweet.getMessage();
            Matcher matcher = pattern.matcher(message);
            Set<String> tags = new HashSet<>();
            while (matcher.find()) {
                tags.add(matcher.group());
            }
            for (String tag : tags) {
                message = message.replaceAll(tag,
                        "<a class=\"tag\" href=\"/tweets/" + tag.substring(1).toLowerCase() + "\">" + tag + "</a>");
            }
            tweet.setMessage(message);
        }
    }
        private void shortenLinks (List < Tweet > tweets) {
            Pattern pattern = Pattern.compile("https?[^ ]+");
            for (Tweet tweet : tweets) {
                String message = tweet.getMessage();
                Matcher matcher = pattern.matcher(message);
                while (matcher.find()) {
                    String link = matcher.group();
                    String shortenedLink = link;
                    if (link.length() > 23) {
                        shortenedLink = link.substring(0, 20) + "...";
                        message = message.replace(link,
                                "<a class=\"tag\" href=\"" + link + "\" target=\"_blank\">" + shortenedLink + "</a>");
                    }
                    tweet.setMessage(message);
                }

            }
        }
    }

