package theme4_classes_and_objects.task25.financeElements.cards.mastercard;

import theme4_classes_and_objects.task25.financeElements.InternetShop;
import theme4_classes_and_objects.task25.financeElements.MoneyAccount;
import utils.ConsoleHelper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Maestro extends MasterCard {
    public Maestro(MoneyAccount moneyAccount, LocalDate startOfUse, LocalDate validTo, String id) {
        super(moneyAccount, startOfUse, validTo, id);

    }

    @Override
    public boolean payToOnlineShop(BigDecimal amount, InternetShop destinationShop) {
        ConsoleHelper.writeToConsole("Данная карта не поддерживает интернет платежи");
        return false;
    }
}
