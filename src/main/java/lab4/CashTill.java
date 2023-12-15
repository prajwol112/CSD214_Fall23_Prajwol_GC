package lab4;
import java.util.ArrayList;
import java.util.List;

public class CashTill {

        private List<SaleableItem> itemsSold;

        public CashTill() {
            itemsSold = new ArrayList<>();
        }

        public void sellItem(SaleableItem item) {
            item.sellItem();
            itemsSold.add(item);
        }

    public double getTotalSales() {
        double total = 0;
        for (SaleableItem item : itemsSold) {
            total += item.getPrice();
        }
        return total;
    }


}