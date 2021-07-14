package com.company;

import java.util.List;

public class MovieEntity {

    private String title;
    private String genera;
    private int runtime;
    private String trailer;


// this wont work right
//   private List<String> movieList;

    public static <T extends Comparable<T>> int greaterThan(T[] numArray, T element){
        int count = 0;
        for(T e : numArray){
            if(e.compareTo(element) > 0){
                ++count;
            }
        }
        return count;
    }



    public MovieEntity() {
    }

    public MovieEntity(String title, String genera, int runtime, String trailer) {
        this.title = title;
        this.genera = genera;
        this.runtime = runtime;
        this.trailer = trailer;
//        this.movieList = movieList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenera() {
        return genera;
    }

    public void setGenera(String genera) {
        this.genera = genera;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
    public String movieQuote(){
        return "Time to make the chimichanga's";
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "title='" + title + '\'' +
                ", genera='" + genera + '\'' +
                ", runtime=" + runtime +
                ", trailer='" + trailer +
                '}';
    }
}
