package com.tw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ScoreService {
    List stuList = StudentService.stuList;


    public static final String TRUE_TYPE_NUMBER="请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";
    public static final String BE_TYPE_NUMBER="请输入要打印的学生的学号（格式：学号,学号,学号,...）,按回车键提交\n";
    public static final String REPORT_TITLE="成绩单\n";
    public static final String REPORT_ITEM_TITLE="姓名|数学|语文|英语|编程|平均分|总分\n";
    public static final String DIVIDE_LINE="========================\n";
    public static final String AVERAGE_TITLE="全班总分平均数：";
    public static final String MEDIAN_TITLE="全班总分中位数：";

    public ScoreService() {
    }

    public ScoreService(List stuList) {
        this.stuList = stuList;
    }

    String printMenu(){
        return "1.添加学生\n2.生成成绩单\n3.退出\n请输入你的选择(1~3)\n";
    }

    String generatescoreItem(Student student){
        return student.getName() +"|"+ student.getScores().get("数学") +"|"+ student.getScores().get("语文")+"|"
                + student.getScores().get("英语") +"|"+ student.getScores().get("编程")+"|" + student.getAvageScore() +"|"
                + student.getTotalScore()+"\n";

    }


    Integer getAllMedium(List<Student> stuList){
        List<Integer> totalScoreList = new ArrayList();
        for (Student student : stuList){
            totalScoreList.add(student.getTotalScore());
        }

        int index = totalScoreList.size() / 2;

        if (stuList.size() == 1) return stuList.get(0).getTotalScore();

        List<Integer> totalScoreList1 = totalScoreList.stream().sorted().collect(Collectors.toList());
        return totalScoreList1.size() % 2 == 0 ? (totalScoreList1.get(index) + totalScoreList1.get(index - 1)) / 2 : totalScoreList1.get(index);
    }


    String generateScore(List<Student> stuList){
        String allStuScore = "";
        Double allAvg = 0.0;
        Integer allMedium = getAllMedium(stuList);
        Integer allTotalScore = 0;

        for (Student student : stuList){
            allStuScore += generatescoreItem(student);
            allTotalScore += student.getTotalScore();
        }

        allAvg = Double.parseDouble(allTotalScore.toString()) / stuList.size();


        return REPORT_TITLE + REPORT_ITEM_TITLE + DIVIDE_LINE + allStuScore + DIVIDE_LINE + AVERAGE_TITLE + allAvg + "\n" + MEDIAN_TITLE + allMedium;
    }

    boolean isStuNoinList(List<Student> stuList, String InputstuNo){
        List stuNoList = new ArrayList();

        for (Student stu : stuList){
            stuNoList.add(stu.getName());
        }
        return stuNoList.contains(InputstuNo);
    }

    String printScore(){
        System.out.println(BE_TYPE_NUMBER);

        while (true) {
            Scanner sc = new Scanner(System.in);
            String stuNo = sc.nextLine();

            if (isStuNoinList(stuList, stuNo)) return TRUE_TYPE_NUMBER;

            return generateScore(stuList);
        }
    }
}



