package theme4_classes_and_objects.task23;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static utils.ConsoleHelper.*;

public class ATM extends Thread {
    private static long counter;
    /*Экзекутор для обслуживания клиентов*/
    private final ExecutorService service = Executors.newSingleThreadExecutor();
    /*Очередь для хранения результатов обслуживания клиентов (Future возвращенный их Callable)*/
    private final LinkedBlockingQueue<Future<Boolean>> resultQueue = new LinkedBlockingQueue<>();
    private final long id = ++counter;
    /*Нить для обработки результатов обслуживания клиентов*/
    Thread checkThread;
    /*Индикатор работы волатильный т.к. к нему образщаются с разных потоков*/
    private volatile boolean isWorking;
    /*Атомик интегер тут потому что данные числа используются разными потоками*/
    private AtomicInteger countOf20;
    private AtomicInteger countOf50;
    private AtomicInteger countOf100;
    public ATM(int initialCountOf20, int initialCountOf50, int initialCountOf100) throws WrongMoneyCountException {
        if (initialCountOf20 < 0 || initialCountOf50 < 0 || initialCountOf100 < 0) {
            throw new WrongMoneyCountException();
        }
        this.countOf20 = new AtomicInteger(initialCountOf20);
        this.countOf50 = new AtomicInteger(initialCountOf50);
        this.countOf100 = new AtomicInteger(initialCountOf100);
        startATM();
    }

    public boolean isWorking() {
        return isWorking;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                /*пока не прерван добавляем одоного клиента и future
                с результатом его обслуживания в очередь для анализа результатов*/
                TimeUnit.MILLISECONDS.sleep(5000);
                resultQueue.add(addOneClient());
            }
        } catch (InterruptedException e) {
            writeToConsole(String.format("Работа АТМ №%d остановлена",id));
        }
        /*Устанавливаем индикатор работы на false*/
        isWorking = false;
        service.shutdown();
    }
    /*Запускаем банкомат, поток анализа результатов сервиса и устанавливаем индикатор в true*/
    public void startATM() {
        start();
        isWorking = true;
        checkThread = new CheckThread(resultQueue);
        checkThread.start();

    }
/*Остановка банкомата. Отсанавливает основной поток и поток анализа резульатов сервиса*/
    public void stopATM() {
        interrupt();
        checkThread.interrupt();
    }

       public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("В банкомате №%d осталось %d купюр по 100, %d купюр по 50, %d купюр по 20",
                id,countOf100.get(),countOf50.get(),countOf20.get());
    }
    /*
   *Бизнес логика алогитма выдачи купюр из банкомата. Мелкими и средними купюрами покрывается остаток который невозможно выдать крупными
   *Затем при наличии выдаются крупные, затем при их отсутствии снова средние и затем снова мелкие.
   * Если всю сумму можно выдать то применяются изменения к амтоиным числам и возвращается true
   Если же нужную сумму выдать невозможно то списания средств с банкомата и соответственно выдачи не происхлдит- возвращается false*/
    public synchronized boolean takeMoney(int sum) {
        int countOfNeeded20 = 0;
        int countOfNeeded50 = 0;
        int countOfNeeded100 = 0;
        int countOfReal20 = countOf20.get();
        int countOfReal50 = countOf50.get();
        int countOfReal100 = countOf100.get();
        while (sum % 50 != 0) {
                if (countOfReal20 == 0) {
                    return false;
                }
                countOfNeeded20++;
                countOfReal20--;
                sum -= 20;
            }
            if (sum % 100 != 0) {
                if (countOfReal50 == 0) {
                    return false;
                }
                countOfNeeded50++;
                countOfReal50--;
                sum -= 50;
            }
            while (sum > 0 && countOfReal100 > 0) {
                countOfNeeded100++;
                countOfReal100--;
                sum -= 100;
            }
        while (sum > 0 && countOfReal50 > 0) {
            countOfNeeded50++;
            countOfReal50--;
            sum -= 50;
        }

        while (sum > 0 && countOfReal20 > 0) {
            if (sum % 20 > 0) {
                return false;
            }
            countOfNeeded20++;
            countOfReal20--;
            sum -= 20;
        }
        if (sum > 0) {
            return false;
        } else {
            countOf100.getAndAdd(-countOfNeeded100);
            countOf50.getAndAdd(-countOfNeeded50);
            countOf20.getAndAdd(-countOfNeeded20);
            writeToConsole(String.format("Выдано %d купюр по 100, %d купюр по 50, и %d купюр по 20 рублей.",
                    countOfNeeded100, countOfNeeded50, countOfNeeded20));
            return true;
        }
    }
    /*Синхроизированный метод для атомарного добавления купюр.
    * Выкидывает пробрасываемое исключение если количества купюр меньше 0*/
    public synchronized void putMoney(int addedCountOf20,int addedCountOf50,int addedCountOf100) throws WrongMoneyCountException {
        if(addedCountOf20<0 || addedCountOf50<0 || addedCountOf100 < 0){
            throw new WrongMoneyCountException();
        }
        this.countOf20.getAndAdd(addedCountOf20);
        this.countOf50.getAndAdd(addedCountOf50);
        this.countOf100.getAndAdd(addedCountOf100);
    }
/*Отдельные методы для добавления отедльного вида купюр
* */
    public void put50(int count) throws WrongMoneyCountException {
        putMoney(0,count,0);
    }
    public void put20(int count) throws WrongMoneyCountException {
        putMoney(count,0,0);
    }
    public void put100(int count) throws WrongMoneyCountException {
        putMoney(0,0,count);
    }
/*В экзекутор добавляется одна Callable задача - т.е. Один клиент.
 Возвращается future с результатом обслуживания клиента*/
    public Future<Boolean> addOneClient() {
        Client client = Client.newClient(this);
        writeToConsole(String.format("К банкомату №%d подошел клиент №%d. Он хочет снять %d рублей.",
                id,client.getId(),client.getSumNeeded()));
        return service.submit(client);
    }
/*Вывод на экран панели управления банкоматом*/
    public void printControlpanel() {
        writeToConsoleWithDecorator(String.format("============ATM   %d==============",id));
        writeToConsole("==========CONTROL PANEL===========");

        writeToConsole("Выберите действие:");
        writeToConsole(String.format("1 Выключить банкомат №%d",id));
        writeToConsole(String.format("2 Пополнить купюрами по 20 банкомат №%d",id));
        writeToConsole(String.format("3 Пополнить купюрами по 50 банкомат №%d",id));
        writeToConsole(String.format("4 Пополнить купюрами по 100 банкомат №%d",id));
        writeToConsole("ВВЕДИТЕ ЛЮБУЮ ДРУГУЮ ЦИФРУ чтобы перейти к следующему банкомату");
        writeToConsoleWithDecorator(this.toString());
    }
}
