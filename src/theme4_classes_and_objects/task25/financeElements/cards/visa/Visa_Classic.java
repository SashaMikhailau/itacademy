package theme4_classes_and_objects.task25.financeElements.cards.visa;

import theme4_classes_and_objects.task25.financeElements.MoneyAccount;

import java.time.LocalDate;

public class Visa_Classic extends Visa {
    public Visa_Classic(MoneyAccount moneyAccount, LocalDate startOfUse, LocalDate validTo, String id) {
        super(moneyAccount, startOfUse, validTo, id);
    }
}
