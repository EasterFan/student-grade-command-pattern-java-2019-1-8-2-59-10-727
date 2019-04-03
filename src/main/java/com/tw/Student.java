package com.tw;

import java.util.Map;

public class Student {
    private String name;
    private String no;
    private Map<String,Integer> scores;

    public Student(String name, String no, Map scores) {
        this.name = name;
        this.no = no;
        this.scores = scores;
    }

    public Integer getTotalScore(){
       return scores.get("语文") + scores.get("数学") + scores.get("英语") + scores.get("编程");
    }

    public Double getAvageScore(){
        return Double.parseDouble(getTotalScore().toString()) / 4;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Map getScores() {
        return scores;
    }

    public void setScores(Map scores) {
        this.scores = scores;
    }
}
