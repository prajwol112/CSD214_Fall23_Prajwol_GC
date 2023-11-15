package lab3.q3;

import java.util.Date;

public class DiscMag extends Magazine{
    private Date newIssue;

    public DiscMag(String title, Date currIssue, Double price, Integer copies) {
        super(title,currIssue,price,copies);
        this.newIssue = currIssue;
    }

    public Date getNewIssue() {
        return newIssue;
    }

    public void setNewIssue(Date newIssue) {
            this.newIssue = newIssue;
        }

    @Override
    public Date getCurrIssue() {
        return newIssue;
    }

}
