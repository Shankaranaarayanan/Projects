package com.test.entity;


public class user1 {
    private String name;
    private int age;
    private String rollno;

    public user1(String n, int a, String r){
        name = n;
        age = a;
        rollno = r;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getRollno(){
        return rollno;
    }
}
