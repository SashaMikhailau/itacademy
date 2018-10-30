package theme3_arrays_and_strings.task21;

public class BenchMarkStringBuilder extends BenchMark {
    StringBuilder sb = new StringBuilder();
    public BenchMarkStringBuilder(long time) {
        super(time);
    }

    @Override
    public void doOperation() {
        sb.append("a");
    }
}
