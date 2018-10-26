package theme4_classes_and_objects.task23;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
/*Каждый клиент реализует коллэбл и запускается экзекутором в потоке банкомата.
* Метод колл возвращает был ли клиент обслужен*/
public class Client implements Callable<Boolean> {
    private static long counter;
    private final long id = ++counter;
    private final int sumNeeded;
    private final ATM atm;

    public long getId() {
        return id;
    }

    public int getSumNeeded() {
        return sumNeeded;
    }
    /*Используем нитевый рандом, т.к. обычный в разных нитях выдает одинаковые числа рандома*/
    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    private Client(ATM atm,int sumNeeded) {
        this.atm = atm;
        this.sumNeeded = sumNeeded;
    }

    /*Фабричный метод*/
    public static Client newClient(ATM atm) {
        return new Client(atm,random.nextInt(100) * 20 + 20);
    }
    /**/
    @Override
    public Boolean call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return atm.takeMoney(sumNeeded);
    }
}
