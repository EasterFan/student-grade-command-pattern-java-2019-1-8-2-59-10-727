package com.tw;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class StudentServiceTest {

    @Test
    public void should_return_student_when_given_correct_string(){
        String string = "fdf,123,语文:100,数学:100,英语:100,编程:100";
        String string2 = "fdf,120,语文:10,数学:10,英语:10,编程:10";
        StudentService studentService = new StudentService();

        Student actual = studentService.isStuInfoEffctive(string);
        assertEquals("fdf",actual.getName());
        assertEquals("123",actual.getNo());
        assertEquals(4,actual.getScores().size());
    }

    @Test
    public void should_return_error_when_given_wrong_str(){
        String string = "fdf,1错误3,:100";
        StudentService studentService = new StudentService();

        Student actual = studentService.isStuInfoEffctive(string);
        assertEquals(null,actual);
    }


}
