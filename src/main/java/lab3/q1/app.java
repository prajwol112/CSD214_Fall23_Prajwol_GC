package lab3.q1;

import java.util.LinkedList;

import static lab3.q1.q1.downsize;
import static lab3.q1.q1.reverse;

public class app {
    public static void main(String[] args) {
        LinkedList<String> employeeName = new LinkedList<>();
        employeeName.add("Prajwol");
        employeeName.add("Manish");
        employeeName.add("Biraj");
        employeeName.add("Shivam");

        LinkedList<String> alphabet = new LinkedList<>();
        alphabet.add("A");
        alphabet.add("B");
        alphabet.add("C");

        // Printing the employeeName and alphabet before the downsize and reverse and after the downsize and reverse.
        System.out.println(employeeName);
        downsize(employeeName, 1);
        System.out.println(employeeName);

        System.out.println(alphabet);
        reverse(alphabet);
        System.out.println(alphabet);


    }
}
