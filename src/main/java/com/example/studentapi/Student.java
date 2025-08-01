package com.example.studentapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="students")

public class Student{
    @Id
    private String id;
    private String name;
    private String email;
    private int age;

    public Student(){}

    public Student(String name,String email,int age){
        this.name=name;
        this.email=email;
        this.age=age;
    }
    //Getters and setters

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    
}