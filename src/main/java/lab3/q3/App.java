package lab3.q3;

import java.util.ArrayList;
import java.util.Date;

public class App {
    ArrayList<Publication> publications=new ArrayList<>();
    ArrayList<Book> books=new ArrayList<>();
    ArrayList<Magazine> magazines=new ArrayList<>();
    ArrayList<DiscMag> discMags=new ArrayList<>();


    public void run(){
        books.add(new Book("To kill a Movkingbird", 100.0, 10, "Harper Lee"));
        books.add(new Book("Da Vinci Code", 11.1, 10, "Dan Brown"));
        magazines.add(new Magazine("Time",new Date(2022,1,4), 2.1, 1000));
        discMags.add(new DiscMag("Time",new Date(2022,5,26), 1.0, 10));

        /**editing the 1st book price to 200.0 and revoming the 2nd book**/
        books.get(0).setPrice(200.0);
        books.remove(1);


        /**printing all books**/
        for(Book b:books){
            System.out.println(b.tostring());
        }
        /**printing all magazines**/
        for(Magazine m:magazines){
            System.out.println(m.tostring());
        }
        /**printing all discMags**/
        for(DiscMag d:discMags){
            System.out.println(d.tostring());
        }
    }

}
