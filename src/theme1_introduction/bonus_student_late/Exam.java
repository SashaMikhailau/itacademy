package theme1_introduction.bonus_student_late;

import java.time.LocalTime;


public class Exam {

        private String name;
        private LocalTime examDate;

        public Exam(String name,int hour,int minute) {
            this.name = name;
            this.examDate = LocalTime.of(hour, minute);
        }

        public String getName() {
            return name;
        }

        public LocalTime getExamDate() {
            return examDate;
        }

}
