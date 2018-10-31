package theme4_classes_and_objects.task25.financeElements.cards.mastercard;

import theme4_classes_and_objects.task25.financeElements.InternetShop;
import theme4_classes_and_objects.task25.financeElements.MoneyAccount;
import theme4_classes_and_objects.task25.financeElements.cards.VipService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MasterCard_Platinum extends MasterCard implements VipService {
    public MasterCard_Platinum(MoneyAccount moneyAccount, LocalDate startOfUse, LocalDate validTo, String id) {
        super(moneyAccount, startOfUse, validTo, id);
    }

}
