package sortingandsearching;

import utils.CommonUtils;

/**
 * @ClassName Merge
 * @Description: 合并两个有序数组
 * @Author gravel
 * @Date 2019/11/22
 * @Version V1.0
 **/
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int last = m + n - 1;
        for (int j = n - 1; j >= 0; ) {
            for (int i = m-1; i >= -1 && j >= 0; ) {

                if (i>=0&&nums1[i] > nums2[j]) {
                    int temp = nums1[last];
                    nums1[last] = nums1[i];
                    nums1[i] = temp;
                    i--;
                    last--;
                } else {
                    int temp = nums1[last];
                    nums1[last] = nums2[j];
                    nums2[j] = temp;
                    j--;
                    last--;
                }

            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        new Merge().merge(nums1, 0, new int[]{1}, 1);
        CommonUtils.printArr(nums1);
    }
}
