package theme4_classes_and_objects.task25.financeElements;

import java.math.BigDecimal;
import java.time.LocalDate;
/*Композицией вмещает в себя банковский счет и декорирует его под методы возможных операций с карточками*/
public abstract class BankCard {
    private MoneyAccount moneyAccount;
    private LocalDate startOfUse;
    private LocalDate validTo;
    private String id;
    public BankCard(MoneyAccount moneyAccount, LocalDate startOfUse, LocalDate validTo, String id) {
        this.moneyAccount = moneyAccount;
        this.startOfUse = startOfUse;
        this.validTo = validTo;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("карта %s №%s %s",getClass().getSimpleName(),id,moneyAccount.getOwner().getSurname());
    }

    public MoneyAccount getMoneyAccount() {
        return moneyAccount;
    }

    public boolean pay(BigDecimal amount, MoneyAccount destinationAccount) {
        return moneyAccount.transferTo(amount, destinationAccount);
    }
    public boolean transferToAnotherCard(BigDecimal amount,BankCard destinationCard) {
        return moneyAccount.transferTo(amount, destinationCard.getMoneyAccount());
    }

    public boolean takeMoneyFromAtm(BigDecimal amount, ATM sourceAtm){
        return sourceAtm.transferTo(amount,moneyAccount);
    }

    public boolean putMoneyInAtm(BigDecimal amount, ATM destAtm) {
        return moneyAccount.transferTo(amount, destAtm);
    }


    public boolean payToOnlineShop(BigDecimal amount, InternetShop destinationShop) {
        return moneyAccount.transferTo(amount, destinationShop.getMoneyAccount());
    }
}

