package lab3.q3;

import java.util.Date;

public class Magazine extends Publication{
    private Integer orderQty;
    private Date currIssue;

    public Magazine(){orderQty=10;}

    public Magazine(String title, Date currIssue, Double price, Integer copies) {
        this();
        setTitle(title);
        setPrice(price);
        setCopies(copies);
        setCurrIssue(currIssue);
    }

    /** Setters and getters for the order quantity **/
    public Integer getOrderQty() {
        return orderQty;
    }
    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

    /** Setters and getters for the current issue **/
    public Date getCurrIssue() {
        return currIssue;
    }
    public void setCurrIssue(Date currIssue) {
        this.currIssue = currIssue;
    }

    @Override
    public String tostring() {
        return "Magazine{" + "orderQty=" + orderQty + ", currIssue=" + currIssue + "}" + super.tostring();
    }
}
