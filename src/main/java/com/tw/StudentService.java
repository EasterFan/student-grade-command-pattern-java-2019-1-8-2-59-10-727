package com.tw;

import java.util.*;

public class StudentService {
    public static List stuList = new ArrayList();

    Student isStuInfoEffctive(String userInput){

        // 判断姓名是否包含特殊符号  学号是否包含数字
        if (userInput.split(",").length == 1 || userInput.split(",")[0].matches(".*[~!@#$%^&*()_+|<>,.?/:;'\\\\[\\\\]{}\\\"]+.*")
                || !userInput.split(",")[1].matches("[0-9]*")) return null;

        String stuName = userInput.split(",")[0];
        String stuNo = userInput.split(",")[1];

        List inputList = Arrays.asList(userInput.split(","));
        Map klassMap = new HashMap();
        for (int i = 2; i < inputList.size();i++){
            klassMap.put(inputList.get(i).toString().split(":")[0],Integer.parseInt(inputList.get(i).toString().split(":")[1]));
        }

        Student student = new Student(stuName,stuNo,klassMap);
        return student;

    }


    void dealMenu1(){
        System.out.println("请输入学生信息（格式:姓名,学号,学科:成绩,...），按回车提交\n");

        while (true) {
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            if (isStuInfoEffctive(userInput) != null) {
                Student student = isStuInfoEffctive(userInput);
                stuList.add(student);
                System.out.println("学生"+student.getName()+"的成绩被添加\n");
                break;

            } else {
                System.out.println("请按正确的格式输入（格式:姓名,学号,学科:成绩,...）\n");
            }
        }


    }



}
