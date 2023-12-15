package lab4;

public interface SaleableItem {
    public default void sellCopy() {
    }

    public default double getPrice() {
        return 0;
    }

    void sellItem();
}
