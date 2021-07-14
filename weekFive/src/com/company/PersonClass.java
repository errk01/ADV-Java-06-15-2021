package com.company;

public class PersonClass {

    private int height;
    private String eyeColor;
    private String job;
    private String name;

    public PersonClass(int height, String eyeColor, String job, String name) {
        this.height = height;
        this.eyeColor = eyeColor;
        this.job = job;
        this.name = name;
    }

    public PersonClass() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String running(){
        return "I dont like to run";
    }

    @Override
    public String toString() {
        return "PersonClass{" +
                "height=" + height +
                ", eyeColor='" + eyeColor + '\'' +
                ", job='" + job + '\'' +
                ", name=" + name +
                '}';
    }

}
