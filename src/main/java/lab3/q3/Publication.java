package lab3.q3;

public abstract class Publication {
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
    public Double getPrice() {
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

    public void sellCopy(){
     }

}
