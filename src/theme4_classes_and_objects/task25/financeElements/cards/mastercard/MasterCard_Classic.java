package theme4_classes_and_objects.task25.financeElements.cards.mastercard;

import theme4_classes_and_objects.task25.financeElements.InternetShop;
import theme4_classes_and_objects.task25.financeElements.MoneyAccount;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MasterCard_Classic extends MasterCard{
    public MasterCard_Classic(MoneyAccount moneyAccount, LocalDate startOfUse, LocalDate validTo, String id) {
        super(moneyAccount, startOfUse, validTo, id);
    }

    @Override
    public boolean payToOnlineShop(BigDecimal amount, InternetShop destinationShop) {
        return false;
    }
}
