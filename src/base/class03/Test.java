package base.class03;

import java.util.Arrays;

public class Test {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxBits(arr));
    }

    public static void radixSort(int[] arr, int l, int r, int maxBit) {
        final int digit = 10;
        int[] bucket = new int[r - l + 1];
        for (int d = 1; d <= maxBit; d++) {
            int[] counts = new int[digit];
            for (int i = l; i <= r - l; i++) {
                int bitNum = getBit(arr[i], d);
                counts[bitNum]++;
            }
            for (int j = 1; j < digit; j++) {
                counts[j] = counts[j - 1] + counts[j];
            }
            for (int i = r; i >= l; i--) {
                int bitNum = getBit(arr[i], d);
                bucket[--counts[bitNum]] = arr[i];
            }
            for (int i = l; i <= r - l; i++) {
                arr[i] = bucket[i];
            }
        }
    }

    public static int getBit(int num, int digit) {
        return (num / (int) (Math.pow(10, digit - 1))) % 10;
    }

    public static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        //获取arr中的最大值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        //获取arr中的最大值的最高位的数（123则返回第百位即2）
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(maxBits(new int[]{3, 432, 546546, 43242, 765756765, 432, 321}));
//        System.out.println(getBit(4356,2));
        int[] arr = {23, 96, 158, 72, 21, 9, 325, 8};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
