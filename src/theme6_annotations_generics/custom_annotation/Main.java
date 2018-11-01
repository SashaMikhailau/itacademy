package theme6_annotations_generics.custom_annotation;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        /*Тестируем данный класс. Передаем внутрь объект,
        чтобы можно было тестировать не только статические методы*/
        AnnotationCalculation.calculateMethodsInClass(Main.class,new Main());
    }

    @CalcMethodTime
    public static String testMultiply() {
        BigInteger big = BigInteger.valueOf(1);
        for (int i = 1; i < 40000; i++) {
            big = big.multiply(BigInteger.valueOf(i));
        }
        return big.toString();
    }

    @CalcMethodTime
    public String testAdd() {
        BigInteger big = BigInteger.valueOf(1);
        for (int i = 1; i < 40000; i++) {
            big = big.add(BigInteger.valueOf(i));
        }
        return big.toString();
    }


    public String testSubstract() {
        BigInteger big = BigInteger.valueOf(1);
        for (int i = 1; i < 40000; i++) {
            big = big.subtract(BigInteger.valueOf(i));
        }
        return big.toString();
    }
    /*При степени больше 11 происходит переполнение и выкидывается исключение*/
    @CalcMethodTime
    public String testPow() {
        BigInteger big = BigInteger.valueOf(2);
        for (int i = 1; i < 11; i++) {
            big = big.pow(i);
        }
        return big.toString();
    }

}
