package com.project.mytest;

public class RocketElement {
    private String name;
    private int id;



    public RocketElement(String name){
        this.name = name;
        this.id = 0;
    }

    public RocketElement(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setImageUri(int id) {
        this.id = id;
    }
}
