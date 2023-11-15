package lab3.q1;

import java.util.LinkedList;

public class q1 {

    public static void downsize( LinkedList<String> employeeName, int n) {
        int i = 1;
//        while (employeeName.size() > 1) {
        for (int j = 0; j < employeeName.size(); j++) {
            if (i % n == 0) {
                employeeName.remove(i++ - 1);
            }
            i++;
        }
    }


    public static void reverse(LinkedList<String> alphabet) {
        LinkedList<String> temp = new LinkedList<>();
        for (int i = 0; i < alphabet.size(); i++) {
            temp.add(alphabet.get(i));
        }
        for (int i = 0; i < alphabet.size(); i++) {
            alphabet.set(i, temp.get(alphabet.size() - i - 1));
        }
    }
}
