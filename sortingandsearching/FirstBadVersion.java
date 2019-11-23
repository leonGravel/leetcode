package sortingandsearching;

import java.util.HashMap;

/**
 * @ClassName FirstBadVersion
 * @Description: 第一个错误的版本
 * @Author gravel
 * @Date 2019/11/23
 * @Version V1.0
 * <p>
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * <p>
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * <p>
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * <p>
 * 示例:
 * <p>
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 * <p>
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * <p>
 * 所以，4 是第一个错误的版本。
 *
 * 思路，就是一个二分查找
 **/
public class FirstBadVersion {
    public int count = 0;

    boolean isBadVersion(int version) {
        count++;
        if (version >= 2126753390) return true;
        return false;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        return start;
    }


    public static void main(String[] args) {
        FirstBadVersion fb = new FirstBadVersion();
        System.out.println(fb.firstBadVersion(1702766719));
        System.out.println(fb.count);
    }
}
