package Task2;

import java.util.ArrayList;


public class mainClass {
    public static void main(String[] args) {
        String[] smus = {"a", "b", "c", "d"};
        ArrayList<String> newmus = new ArrayList<>();
        for (int i = 0; i < smus.length; i++) {
            System.out.print(smus[i]);
            String a= smus[i];
            newmus.add(a);
        }

            System.out.print(smus);
    }
}
