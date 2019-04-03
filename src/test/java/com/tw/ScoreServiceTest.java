package com.tw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ScoreServiceTest {

    @Test
    public void should_return_medium_when_given_all_class_stulist(){

        String string1 = "fdf1,123,语文:100,数学:100,英语:100,编程:100";
        String string2 = "fdf2,124,语文:0,数学:0,英语:0,编程:0";
        String string3 = "fdf3,124,语文:50,数学:50,英语:50,编程:50";
        StudentService studentService = new StudentService();

        Student student1 = studentService.isStuInfoEffctive(string1);
        Student student2 = studentService.isStuInfoEffctive(string2);
        Student student3 = studentService.isStuInfoEffctive(string3);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        ScoreService scoreService = new ScoreService(studentList);

        Integer actual = scoreService.getAllMedium(studentList);

        assertEquals(new Integer(200),actual);

    }





    @Test
    public void should_return_score_recipt_when_given_class_student_list(){
        String string1 = "fdf1,123,语文:100,数学:100,英语:100,编程:100";
        String string2 = "fdf2,124,语文:0,数学:0,英语:0,编程:0";
        StudentService studentService = new StudentService();

        Student student1 = studentService.isStuInfoEffctive(string1);
        Student student2 = studentService.isStuInfoEffctive(string2);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        ScoreService scoreService = new ScoreService(studentList);
        String actual = scoreService.generateScore(studentList);

        assertEquals("成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "fdf1|100|100|100|100|100.0|400\n" +
                "fdf2|0|0|0|0|0.0|0\n" +
                "========================\n" +
                "全班总分平均数：200.0\n" +
                "全班总分中位数：200", actual);
    }
}
