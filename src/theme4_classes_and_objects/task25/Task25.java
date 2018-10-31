package theme4_classes_and_objects.task25;

import theme4_classes_and_objects.task25.financeElements.*;
import theme4_classes_and_objects.task25.financeElements.cards.VipService;
import theme4_classes_and_objects.task25.financeElements.cards.mastercard.MasterCard_Platinum;
import theme4_classes_and_objects.task25.financeElements.cards.visa.Visa_Electron;
import utils.ConsoleHelper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Task25 {
    /*Создать иерархию классов описывающих банковские карточки. Иерархия должна иметь хотя бы три уровня.*/

    public static void main(String[] args) {
        User user1 = new User("Иванов", "Иван", "Иванович", LocalDate.of(1987, 01, 01), "русский");
        User user2 = new User("Петров", "Петр", "Петрович", LocalDate.of(1985, 01, 01), "русский");
        User onlineShopOwner = new User("Чи", "Хуань", "Хи", LocalDate.of(1984, 01, 01), "китаец");
        MoneyAccount myAccount = new MoneyAccount(new BigDecimal(100.5), user1);
        MoneyAccount anotherAccount = new MoneyAccount(new BigDecimal(10.5), user2);
        MoneyAccount onlineShopAccount = new MoneyAccount(new BigDecimal(10000.5), onlineShopOwner);
        BankCard myCard = new MasterCard_Platinum(myAccount, LocalDate.of(2018, 01, 01), LocalDate.of(2021, 01, 01), "0000 5566 7788");
        BankCard anotherCard = new Visa_Electron(anotherAccount, LocalDate.of(2018, 06, 06), LocalDate.of(2021, 06, 06), "0000 0111 7744");
        InternetShop aliexpress = new InternetShop(onlineShopAccount);
        ATM atm = new ATM(new BigDecimal(100.4), "Gorki str., 55");


        myCard.payToOnlineShop(new BigDecimal(10), aliexpress);
        anotherCard.payToOnlineShop(new BigDecimal(10), aliexpress);

        myCard.putMoneyInAtm(new BigDecimal(10), atm);
        anotherCard.takeMoneyFromAtm(new BigDecimal(50), atm);

        myCard.transferToAnotherCard(new BigDecimal(50), anotherCard);
        myAccount.setFrozen(true);
        myCard.transferToAnotherCard(new BigDecimal(50), anotherCard);

        myAccount.setFrozen(false);
        myCard.transferToAnotherCard(new BigDecimal(50), anotherCard);
        ((VipService) myCard).callToConsiergeService();
    }
}
