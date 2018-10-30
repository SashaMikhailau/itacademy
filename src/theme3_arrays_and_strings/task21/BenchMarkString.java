package theme3_arrays_and_strings.task21;

public class BenchMarkString extends BenchMark {
    String string;

    public BenchMarkString(long time) {
        super(time);
    }

    @Override
    public void doOperation() {
        string+="a";

    }
}