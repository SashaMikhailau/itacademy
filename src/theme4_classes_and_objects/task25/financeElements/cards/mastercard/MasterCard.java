package theme4_classes_and_objects.task25.financeElements.cards.mastercard;

import theme4_classes_and_objects.task25.financeElements.MoneyAccount;
import theme4_classes_and_objects.task25.financeElements.BankCard;

import java.time.LocalDate;

public abstract class MasterCard extends BankCard {
    public MasterCard(MoneyAccount moneyAccount, LocalDate startOfUse, LocalDate validTo, String id) {
        super(moneyAccount, startOfUse, validTo, id);
    }

}
