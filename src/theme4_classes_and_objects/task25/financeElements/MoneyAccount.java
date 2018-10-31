package theme4_classes_and_objects.task25.financeElements;

import utils.ConsoleHelper;

import java.math.BigDecimal;
/*Денежный счет переопределяет методы финансового элемента с учетом возможности заморозки*/
public class MoneyAccount extends FinanceElement {
    private final User owner;
    private volatile boolean isFrozen;

    public MoneyAccount(BigDecimal moneyAmount, User owner) {
        super(moneyAmount);
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public synchronized void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    @Override
    public synchronized boolean transferTo(BigDecimal amount, FinanceElement destination) {
        if(isFrozen) {
            ConsoleHelper.writeToConsole("Счет отправителя заморожен, невозможно выполнить трансфер");
            return false;
        }
        return super.transferTo(amount, destination);
    }

    @Override
    public String toString() {
        return "Счет "+owner.getSurname();
    }
}
