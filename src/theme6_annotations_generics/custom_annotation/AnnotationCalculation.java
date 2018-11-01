package theme6_annotations_generics.custom_annotation;

import utils.ConsoleHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalTime;
import java.util.stream.Stream;

public class AnnotationCalculation {
    /*Работает как со статическими так и нестатическими методами без аргументов.
    Методы с аргументами сам понимаешь в данном контексте тестировать невозможно*/
    public static void calculateMethodsInClass(Class<?> type, Object object) {
        /*Фильтруем методы переданного класса по наличию аннотации
        , преобразуем в массик строк с результатами теста и выводим в консоль*/
        Stream.of(type.getMethods())
                .filter(method -> method.isAnnotationPresent(CalcMethodTime.class))
                .map(method -> calculateTimeOfExecution(method,object))
                .forEach(text->ConsoleHelper.writeToConsole(text));
    }
    /*Метод для непосредственного рассчета времени вызова онкретного метода*/
    public static String calculateTimeOfExecution(Method method,Object object) {
        try {
            LocalTime startTime = LocalTime.now();
            method.invoke(object);
            LocalTime endTime = LocalTime.now();
            Duration duration = Duration.between(startTime, endTime);
            return String.format("Метод %s вызванный у объекта %s выполнялся %d секунд и %d миллисекунд",
                    method.getName(),object.toString(),duration.getSeconds(),duration.getNano()/1000000);
        } catch (IllegalAccessException| InvocationTargetException e) {
            return String.format("При вызове метода %s произошла ошибка",method.getName());
        }
    }
}
