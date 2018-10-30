package theme3_arrays_and_strings.task21;

    /*Напишите два цикла выполняющих многократное сложение строк, один с помощью оператора сложения и String, а другой с помощью StringBuilder и метода append
    * Сравниет скорость их выполнения*/
    import java.util.concurrent.TimeUnit;
    import java.util.concurrent.atomic.AtomicLong;

    public abstract class BenchMark extends Thread{
        private final long time;
        private AtomicLong count = new AtomicLong(0);

        public BenchMark(long time) {
            this.time = time;
        }

        public long startBenchMark() {
            start();
            try {
                TimeUnit.SECONDS.sleep(time);
                stopBenchMark();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                return count.longValue();
            }
        }


        @Override
        public void run() {
            while (!isInterrupted()) {
                doOperation();
                count.incrementAndGet();
            }
        }

        public void stopBenchMark() {
            interrupt();
        }

        public abstract void doOperation();

    }

