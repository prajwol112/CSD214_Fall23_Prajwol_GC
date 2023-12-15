package lab4;

public class Book extends Publication {
    private String auther;
    public Book(){
    }

    /** Sets the Auther of the Book**/
    public void setAuther(String auther) {
        this.auther = auther;
    }
    public Book(String title, Double price, Integer copies, String auther) {
        super(title, price, copies);
        this.auther = auther;
    }

    /**
     * Important : Need to convert the empty copies to 0 integer value
     * **/
    public void orderCopies(int numCopies){
        setCopies(numCopies+getCopies());
    }

    @Override
    public String toString() {
        return "Book{" +
                "auther='" + auther + '\'' +
                '}';
    }

    @Override
    public void sellItem() {
        sellItem();
    }
}