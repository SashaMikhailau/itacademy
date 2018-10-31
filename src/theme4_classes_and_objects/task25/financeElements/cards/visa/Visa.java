package theme4_classes_and_objects.task25.financeElements.cards.visa;

import theme4_classes_and_objects.task25.financeElements.MoneyAccount;
import theme4_classes_and_objects.task25.financeElements.BankCard;

import java.time.LocalDate;

public abstract class Visa extends BankCard {
    public Visa(MoneyAccount moneyAccount, LocalDate startOfUse, LocalDate validTo, String id) {
        super(moneyAccount, startOfUse, validTo, id);
    }
}
