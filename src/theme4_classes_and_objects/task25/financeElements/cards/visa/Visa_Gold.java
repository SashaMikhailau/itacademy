package theme4_classes_and_objects.task25.financeElements.cards.visa;

import theme4_classes_and_objects.task25.financeElements.MoneyAccount;
import theme4_classes_and_objects.task25.financeElements.cards.VipService;

import java.time.LocalDate;

public class Visa_Gold extends Visa implements VipService {
    public Visa_Gold(MoneyAccount moneyAccount, LocalDate startOfUse, LocalDate validTo, String id) {
        super(moneyAccount, startOfUse, validTo, id);
    }
}
