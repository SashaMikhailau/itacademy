package theme4_classes_and_objects.task25.financeElements;

/*Интернет магазин*/
public class InternetShop {
    public MoneyAccount getMoneyAccount() {
        return moneyAccount;
    }

    private MoneyAccount moneyAccount;

    public InternetShop(MoneyAccount moneyAccount) {
        this.moneyAccount = moneyAccount;
    }
}
