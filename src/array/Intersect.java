package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gravel
 * @date 2019/9/16.
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && !arr.contains(j)) {
                    arr.add(j);
                    break;
                }
            }
        }
        int[] array = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            array[i] = nums2[arr.get(i)];
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new Intersect().intersect(new int[]{4, 7, 9, 7, 6, 7}, new int[]{5, 0, 0, 6, 1, 6, 2, 2, 4}));
    }
}
