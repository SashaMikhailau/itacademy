package theme4_classes_and_objects.task23;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

import static utils.ConsoleHelper.*;

public class CheckThread extends Thread {
    /*Поток для анализа результатов обслуживания клиентов
    Поток при наличии берет из очереди данные об обслуживании клиентов.
    *Если клиент не был обслужен (определяется по результату future вернутом callable
    * то выводится в консоль сообщение о недовольстве клиента*/
    public CheckThread(LinkedBlockingQueue<Future<Boolean>> resultQueue) {
        this.resultQueue = resultQueue;
    }

    private final LinkedBlockingQueue<Future<Boolean>> resultQueue;
    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Future<Boolean> future = resultQueue.take();
                Boolean result = future.get();
                if (!result) {
                    writeToConsoleWithDecorator("Клиент НЕДОВОЛЕН. Денег в банкомате для его нужд не оказалось.");
                }
            }
        }
        catch(ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e) {

        }
        writeToConsole("Поток анализа результатов сервиса был остановлен");
    }
    }


