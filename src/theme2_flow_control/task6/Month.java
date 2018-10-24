package theme2_flow_control.task6;

public class Month {
    private Months months;

    public Month(int number, Year year) throws MyDateException {
        this.year = year;
        if (number < 1 || number > 12) {
            throw new MyDateException();
        }
        months = Months.getByOrdinal(number, year.isVis());
    }

    private Year year;
    public int getNumber(){
        return months.getOrdinalNumber();
    }
    public int getNumberOfDays() {
        return months.getNumberOfDays();
    }
    public void plusMonth(){
        if (months==Months.DECEMBER) {
            months=Months.JANUARY;
            year.plusYear();
        } else{
            months = Months.getByOrdinal(months.getOrdinalNumber() + 1, year.isVis());
        }

    }
}
