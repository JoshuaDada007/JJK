package org.example.twitter.Tweets;

public class Twitter {
    private int id;
    private String userName;
    private String tweet;
    private boolean isLoggedIn;

    public Twitter(int id, String userName, String tweet, boolean isLoggedIn) {
        this.id = id;
        this.userName = userName;
        this.tweet = tweet;
        this.isLoggedIn = isLoggedIn;
    }

    public Twitter() {
        this.id = 0;
        this.userName = "Empty";
        this.tweet = "Empty";
        this.isLoggedIn = false;
    }
    public int getId(){
        return id;
    }
    public String getUserName(){
        return userName;
    }
    public String getTweet(){
        return tweet;
    }
    public boolean isLoggedIn(){
        return isLoggedIn;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setTweet(String tweet){
        this.tweet = tweet;
    }
    public void setLoggedIn(boolean isLoggedIn){
        this.isLoggedIn = isLoggedIn;
    }

    }
