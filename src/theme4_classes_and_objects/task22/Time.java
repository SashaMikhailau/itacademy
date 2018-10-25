package theme4_classes_and_objects.task22;

import java.util.Objects;

public class Time implements Comparable<Time> {
    private final int hour;
    private final int minute;
    private final int second;

    /*При введении значений не укладывающихся в шаблоны выбрасывается исключение.
    *
    * */
    public Time(int hour, int minute, int second) throws WrongTImeException {
        if (hour < 0 || minute < 0 || minute > 59 || second < 0 || second > 59) {
            throw new WrongTImeException();
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;

    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d",hour,minute,second);
    }

    public Time(int sumSeconds) throws WrongTImeException {
        if (sumSeconds < 0) {
            throw new WrongTImeException();
        }
        second = sumSeconds % 60;
        sumSeconds = (sumSeconds - second)/60;
        minute = sumSeconds % 60;
        hour = (sumSeconds - minute)/60;

    }

    public int countSumSeconds() {
        return (hour * 60 + minute) * 60 + second;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hour == time.hour &&
                minute == time.minute &&
                second == time.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, second);
    }

    @Override

    public int compareTo(Time o) {
        return Integer.compare(countSumSeconds(), o.countSumSeconds());
    }
}
