package javase02.t04;


import javase02.t03.Stationery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task {
    static ArrayList<Stationery> sortByPrice(ArrayList<Stationery> set) {

        Collections.sort(set, new Comparator<Stationery>() {
            public int compare(Stationery first, Stationery second) {
                if (first.getPrice() < second.getPrice()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        return set;
    }

    static ArrayList<Stationery> sortByName(ArrayList<Stationery> set) {

        Collections.sort(set, new Comparator<Stationery>() {
            public int compare(Stationery first, Stationery second) {
                return first.getName().compareTo(second.getName());
            }
        });

        return set;
    }

    static ArrayList<Stationery> sortByNameAndPrice(ArrayList<Stationery> set) {

        Collections.sort(set, new Comparator<Stationery>() {
            public int compare(Stationery first, Stationery second) {
                if (first.getPrice() < second.getPrice()) {
                    return 1;
                } else if(first.getPrice() > second.getPrice()) {
                    return -1;
                } else {
                    return first.getName().compareTo(second.getName());
                }
            }
        });

        return set;
    }
}
