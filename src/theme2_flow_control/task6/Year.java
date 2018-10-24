package theme2_flow_control.task6;

public class Year {
    private boolean vis;
    private int number;

    public boolean isVis() {
        return vis;
    }

    public int getNumber() {
        return number;
    }

    public Year(int number) throws MyDateException {
        if(number<0){
            throw new MyDateException();
        }
        this.number = number;
        recalculateVis(number);

    }

    private void recalculateVis(int number) {
        if((number%100==0 && number%400!=0) || number%4!=0) {
            vis = false;
        }
        else {
            vis = true;
        }
    }
    public void plusYear() {
        recalculateVis(++number);
    }
}
