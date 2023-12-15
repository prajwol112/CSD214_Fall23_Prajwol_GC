package lab4;

public abstract class Publication implements SaleableItem{
    private String title;
    private Double price;
    private Integer copies;

    public Publication() {
    }
    public Publication(String title, Double price, Integer copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }
    /** Sets the Title of the Publication**/
    public void setTitle(String title) {
        this.title = title;
    }

    /** Returns the Title of the Publication**/
    public String getTitle() {
        return title;
    }
    /** Sets the Price of the Publication**/
    public void setPrice(Double price) {
        this.price = price;
    }
    /** Returns the Price of the Publication**/

    @Override
    public double getPrice() {
        return price;
    }
    /** Sets the Copies of the Publication**/
    public void setCopies(Integer copies) {
        this.copies = copies;
    }
    /** Returns the Copies of the Publication**/
    public Integer getCopies() {
        if (copies == null){
            copies = 0;
        }
        return copies;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", copies=" + copies +
                '}';
    }

/**
 * sale copy of publicaiton and decrement the number of copies
 * */
    @Override
    public void sellCopy() {
        SaleableItem.super.sellCopy();
        System.out.println("Sold a copy of " + getTitle() + " for $" + getPrice());
        if (getCopies() > 0) {
            setCopies(getCopies() - 1);
        }
    }

}
