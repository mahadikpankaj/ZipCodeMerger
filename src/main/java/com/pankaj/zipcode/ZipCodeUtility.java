package com.pankaj.zipcode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by admin on 4/26/2019.
 */
public class ZipCodeUtility {

    public static long[][] mergeZipCodeRanges(long[][] zipCodeData) {

        //used TreeSet datastructure to hold the array having start and end of range in it. The sort
        TreeSet<long[]> set = new TreeSet<>((a1, a2) -> ((int) (a1[0] - a2[0])));

        Arrays.stream(zipCodeData).forEach(t -> {
            Iterator<long[]> iter = set.iterator();
            boolean updated = false;
            while (iter.hasNext()) {
                long[] arr = iter.next();

                //use short-circuit. If the start value is greater than that of the end value in the sorted set, then no further checks are required
                if(t[0]>=arr[1]){
                    continue;
                }

                //check if the start value in the range falls between existing start and end, if yes, adjust the end
                if (t[0] > arr[0] && t[0] < arr[1]) {
                    arr[1] = t[1] > arr[1] ? t[1] : arr[1];
                    updated = true;
                }

                //check if the end value in the range falls between existing start and end, if yes, adjust the start
                if (t[1] > arr[0] && t[1] < arr[1]) {
                    arr[0] = t[0] < arr[0] ? t[0] : arr[0];
                    updated = true;
                }
            }

            //if the update flag remains false, meaning the range was not overlapping anywhere, so add this new entry in the set
            if (!updated) {
                set.add(new long[]{t[0], t[1]});
            }
        });

        //finally convert the set to array of ranges and return
        long[][] result = set.stream().toArray(long[][]::new);
        return result;
    }
}
