package theme2_flow_control.task6;

public class DayOfMonth {
    private int day;
    private Month month;

    public int getNumber() {
        return day;
    }

    public Month getMonth() {
        return month;
    }
    public void plusDay() {

        if (++day > month.getNumberOfDays()) {
            day = 1;
            month.plusMonth();
        }
    }

    public DayOfMonth(int day, Month month) throws MyDateException {
        this.month = month;
        if (day < 1 || day > month.getNumberOfDays()) {
            throw new MyDateException();
        }
        else{
            this.day = day;
        }

    }
}
