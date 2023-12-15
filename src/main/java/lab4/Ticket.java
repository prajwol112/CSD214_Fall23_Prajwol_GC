package lab4;

public abstract class Ticket implements SaleableItem {
    private String eventName;
    private void setPrice(double price) {
    }

    public Ticket(String eventName, double price) {
        this.eventName = eventName;
        setPrice(price);

    }

    @Override
    public void sellCopy() {
        System.out.println("Selling ticket for " + eventName);
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
