package theme1_introduction.bonus_student_late;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
    private Map<Exam, LocalTime> exams = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    public void goToExam(Exam exam,int hour,int minute) {

            LocalTime arriveTime = LocalTime.of(hour, minute);
            exams.put(exam,arriveTime);


    }


    public String getMessageAboutArriveToExam(Exam exam) {
        LocalTime arriveTime = exams.get(exam);
        LocalTime examTime = exam.getExamDate();
        String result;
        if (arriveTime == null) {
            result = String.format("На экзамен %s студент %s не попал",
                    exam.getName(),name);
        }
        else if(examTime==null){
            result = String.format("Так как дата экзамена %s была задана некорректно, студент %s на него не попал",
                    exam.getName(),name);
        }
        else{
            String arriveTimeInString = df.format(arriveTime);
            long timeDifference = Math.abs(examTime.until(arriveTime, ChronoUnit.MINUTES));

            if(arriveTime.isAfter(examTime))
                result = String.format(
                        "Студент %s опоздал на экзамен %s на %d часов %d минут прийдя в %s", name,exam.getName(),timeDifference/60,timeDifference%60,arriveTimeInString);
            else {
                if (timeDifference > 30) {
                    result = String.format(
                            "Студент %s пришел на экзамен %s заранее на %d часов %d минут, а именно в %s", name, exam.getName(),
                            timeDifference/60,timeDifference%60,arriveTimeInString);
                } else {
                    result = String.format(
                            "Студент %s пришел на экзамен %s вовремя в %s", name, exam.getName(),arriveTimeInString);
                }

            }

        }
        return result;
    }
}
