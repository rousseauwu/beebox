package org.bees.box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algra {
    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(1, 5, 8);
        List<Integer> b = Arrays.asList(2, 4, 9);

        List<Integer> hebing = new ArrayList<>();
        int aIndex = 0;
        int bIndex = 0;
        while (true) {

            if (bIndex == b.size() && aIndex == a.size()) {
                break;
            }

            if (a.get(aIndex) <= b.get(bIndex)) {
                hebing.add(a.get(aIndex));
                aIndex++;
                if (aIndex == a.size()) {
                    hebing.addAll(b.subList(bIndex, b.size()));
                    break;
                }
                continue;
            }

            if (a.get(aIndex) > b.get(bIndex)) {
                hebing.add(b.get(bIndex));
                bIndex++;
                if (bIndex == b.size()) {
                    hebing.addAll(a.subList(aIndex, a.size()));
                    break;
                }
                continue;
            }


        }


        System.out.println(hebing.toString());


    }



}
