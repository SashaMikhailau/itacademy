package theme4_classes_and_objects.task25.financeElements;

import utils.ConsoleHelper;

import java.math.BigDecimal;
/*Основной абстрактный класс всех финансовых иснтрументов (АТМ, СЧЕТ, КАРТОЧКА И т.д.)*/
public abstract class FinanceElement {
    private static final BigDecimal ZERO = new BigDecimal(0);

    protected BigDecimal moneyAmount;

    public FinanceElement(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    @Override
    public String toString() {
        return "Финансовый элемент";
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public synchronized boolean transferTo(BigDecimal amount, FinanceElement destination) {
       if(!destination.makeTransfer(amount)||moneyAmount.compareTo(amount)<0){
           ConsoleHelper.writeToConsole(String.format("Трансфер [%s - > %s] в количестве %s рублей НЕ завершен",toString(),destination.toString(),amount.toPlainString()));
           return false;
       }
        moneyAmount = moneyAmount.subtract(amount);
        ConsoleHelper.writeToConsoleWithDecorator(String.format("Трансфер [%s - > %s] в количестве %s рублей завершен успешно",toString(),destination.toString(),amount.toPlainString()));
        ConsoleHelper.writeToConsole(String.format("Сумма на счетах после операции: %s - %s, %s - %s",toString(),getMoneyAmount().toPlainString(),destination.toString(),destination.getMoneyAmount().toPlainString()));

            return true;
    }

    public synchronized boolean makeTransfer(BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO)<0){
            return false;
        }
        moneyAmount = moneyAmount.add(amount);
        return true;
    }
}
