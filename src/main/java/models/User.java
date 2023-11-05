package models;

import java.util.*;

public class User {
    private Integer id;
    private String name;
    private List<Integer> streamList;
    public User(int id, String name, List<Integer> streamList) {
        this.id = id;
        this.name = name;
        this.streamList = streamList;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getStreamList() {
        return this.streamList;
    }

    public String toString() {
        String s = "models.User{" + ", id=" + id + ", name='" + name +'\'' + ", streamList=' ";
        for(int id : streamList) {
            s += id + " ";
        }
        s += '}';
        return s;
    }
}