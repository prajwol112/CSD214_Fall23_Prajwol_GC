package lab4;

public abstract class  Pencil implements SaleableItem{
    private String color;


    private void setPrice(double price) {
    }

    public Pencil(String color, double price){
        this.color = color;
        setPrice(price);
    }
    @Override
    public void sellCopy() {
        System.out.println("Selling pencil of color " + color);
    }

    public abstract String getColor();
}
