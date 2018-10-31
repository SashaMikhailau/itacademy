package theme4_classes_and_objects.task25.financeElements;

import java.math.BigDecimal;
/*Банкомат*/
public class ATM extends FinanceElement {
    private String address;

    @Override
    public String toString() {
        return "Банкомат по адресу " + address;
    }

    public ATM(BigDecimal moneyAmount, String address) {
        super(moneyAmount);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
