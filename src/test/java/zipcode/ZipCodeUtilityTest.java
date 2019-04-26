package zipcode;

import com.pankaj.zipcode.ZipCodeUtility;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by admin on 4/26/2019.
 */
public class ZipCodeUtilityTest {

    @Test
    public void testZipCodeRangeMergeNoOverlap(){
        long[][] zipCodeData = {{94133, 94133}, {94200, 94299}, {94600, 94699}};
        long[][] expectedArray = {{94133, 94133}, {94200, 94299}, {94600, 94699}};
        long[][] resultArray = ZipCodeUtility.mergeZipCodeRanges(zipCodeData);

        for(int i = 0; i < resultArray.length; i++){
            Assert.assertTrue(Arrays.equals(expectedArray[i], resultArray[i]));
        }

    }
    @Test
    public void testZipCodeRangeMergeWithOverlap(){
        long[][] zipCodeData = {{94133, 94133}, {94200, 94299}, {94226, 94399}};
        long[][] expectedArray = {{94133, 94133}, {94200, 94399}};
        long[][] resultArray = ZipCodeUtility.mergeZipCodeRanges(zipCodeData);

        for(int i = 0; i < resultArray.length; i++){
            Assert.assertTrue(Arrays.equals(expectedArray[i], resultArray[i]));
        }

    }
}
