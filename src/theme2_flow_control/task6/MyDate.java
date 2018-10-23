package theme2_flow_control.task6;

public class MyDate {
    private Year year;
    private Month month;
    private DayOfMonth day;

    public MyDate(int dayNumber, int monthNumber, int yearNumber) throws MyDateException {
        this.year = new Year(yearNumber);
        this.month = new Month(monthNumber, year);
        this.day = new DayOfMonth(dayNumber, month);
    }

    public void plusOneDay() {
        day.plusDay();
    }

    @Override
    public String toString() {
        return String.format("%d %d %d",day.getNumber(),month.getNumber(),year.getNumber());
    }
}
