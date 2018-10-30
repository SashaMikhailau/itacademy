package theme3_arrays_and_strings.task21;

public class Task21 {
    /*"ЭТУ ЗАДАЧУ ТЫ УЖЕ СМОТРЕЛ И ВРОДЕ 9 ПОСТАВИЛ, НО ПОТОМ УДАЛИЛ ПОЧЕМУ ТО*/

        public static void main(String[] args) {
            //больше 4 секунд куча переполнятеся
            long time =4;
            BenchMark benchMark1 = new BenchMarkString(time);
            System.out.println(String.format("За %d секунд было произведено %d  операций со строкой",time,benchMark1.startBenchMark()));
            BenchMark benchMark2 = new BenchMarkStringBuilder(time);
            System.out.println(String.format("За %d секунд было произведено %d  операций с билдером",time,benchMark2.startBenchMark()));
        }





}
