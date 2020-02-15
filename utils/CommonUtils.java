package utils;

import com.sun.tools.javac.util.StringUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 工具类，提供一些基础的工具类方法，类似翻转数组,打印数组
 *
 * @author Gravel
 * @date 2019/9/9.
 */
public class CommonUtils {
    public static boolean isSquare(int n) {
        if (n < 0) return false;
        if (n <= 1) return true;
        int l = 0;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int sq = n / mid;
            if (sq < mid) {
                r = mid - 1;
            } else if (sq > mid) {
                l = mid + 1;
            } else {
                if (n % mid == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false; // fix me!
    }

    public static double findUniq(double arr[]) {
        double l = arr[0];
        double r = arr[arr.length - 1];
        if (l != r) {
            if (arr[arr.length - 2] == r) {
                return l;
            } else {
                return r;
            }
        } else {
            int s = 0;
            int e = arr.length - 1;
            for (int i = 1; i <= arr.length - 2; i++) {
                if (arr[i] != l) {
                    return arr[i];
                }
            }
        }
        // Do the magic
        return arr[0];
    }

    public static int[] sortArray(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            for (int j = array.length - 1; j > i; j--) {
//
//                if (array[i] < array[j] && array[i] % 2 != 0 && array[j] % 2 != 0) {
//                    int t = array[i];
//                    array[i] = array[j];
//                    array[j] = t;
//                }
//            }
//        }
        quitSort(array, 0, array.length - 1);
        return array;
    }

    private static void quitSort(int[] array, int start, int end) {
        if (start > end) return;
        int temp = array[start];
        int l = start;
        int r = end;
        while (l != r) {
            if (array[r] % 2 == 0) {
                r--;
                continue;
            }
            if (array[l] % 2 == 0) {
                l++;
                continue;
            }
            while (array[r] <= temp && l < r) {
                r--;
            }
            while (array[l] >= temp && l < r) {
                l++;
            }
            if (l < r && array[r] % 2 != 0 && array[l] % 2 != 0) {
                int t = array[l];
                array[l] = array[r];
                array[r] = t;
            }
        }
        if (array[start] % 2 != 0 && array[l] % 2 != 0) {
            array[start] = array[l];
            array[l] = temp;

        }
        quitSort(array, start, l - 1);
        quitSort(array, r + 1, end);
    }

    public static int solution(int number) {
        //TODO: Code stuff here
        int i = 0;
        int res = 0;
        int j = 0;
        while (i < number - 3) {
            i = i + 3;
            if (i % 3 == 0 && i % 5 == 0) {
                res += i;
                continue;
            }
            if (i % 3 == 0) {
                res += i;
            }
        }
        while (j < number - 5) {
            j = j + 5;
            if (j % 3 == 0 && j % 5 == 0) {
                continue;
            }
            if (j % 5 == 0) {
                res += j;
            }
        }
        return res;
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbers.length, 1);
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            map.putIfAbsent(numbers[i], i);
            int tar = target - numbers[i];
            if (map.get(tar) != null) {
                res[1] = i;
                res[0] = map.get(tar);
                return res;
            }
        }
        return res; // Do your magic!
    }

    public static boolean validatePin(String pin) {
        if (null == pin) return false;
        int len = pin.getBytes().length;
        char[] chars = pin.toCharArray();
        if (len != 4 && len != 6) {
            return false;
        }
        for (char c : chars) {
            if ((int) c < 48 || (int) c > 57) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(3456));
        System.out.println(validatePin("090909"));
        printArr(sortArray(new int[]{2,3,13,8,6,5,7,33,28}));
    }

    public static void printArr(int[] nums) {
        StringBuffer sb = new StringBuffer("[");
        Arrays.stream(nums).forEach(value -> sb.append(value).append(","));
        System.out.println(new StringBuffer(sb.substring(0, sb.length() - 1)).append("]").toString());
    }
}
