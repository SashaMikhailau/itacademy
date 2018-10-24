package theme1_introduction.bonus_student_late;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static utils.ConsoleHelper.*;

public class Main {
    /*"Студент должен сдать экзамен в определенное время (в 9:30). Он приходит в комнату экзамена в определенное время (например, 9:40).
    Считается, что студент пришел вовремя, если он прибыл на экзамен за полчаса до экзамена или вовремя.
    Если он приехал более чем на 30 минут раньше, он пришел зарано. Если он пришел после начала экзамена, он опоздал.
    Напишите программу, в которой задается время экзамена и время прибытия, и выведет, пришел ли ученик вовремя, заранее или опоздал,
    и на сколько часов или минут он пришел раньше или опоздал (если будет получатся).
    При решении задачи время можно представлять в виде 2-х чисел (часы, минуты).~~"*/
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        String[] names = {"Вася", "Коля", "Даша"};
        for (String name : names) {
            students.add(new Student(name));
        }
        Set<Exam> exams = new HashSet<>();

            exams.add(new Exam("Java", 18, 0));
            exams.add(new Exam("English", 14, 20));
            exams.add(new Exam("Ufo", 21, 40));


        Random random = new Random();

        students.forEach(student -> exams.forEach(exam -> {
            student.goToExam(exam, random.nextInt(24), random.nextInt(60));
            writeToConsole(student.getMessageAboutArriveToExam(exam));
        }));
    }
}
