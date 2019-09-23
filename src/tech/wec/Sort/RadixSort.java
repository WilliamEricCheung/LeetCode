package tech.wec.Sort;

public class RadixSort {
    /**
     * 基数排序（LSD 从低位开始）
     *
     * 基数排序适用于：
     *  (1)数据范围较小，建议在小于1000
     *  (2)每个数值都要大于等于0
     *
     * ①. 取得数组中的最大数，并取得位数；
     * ②. arr为原始数组，从最低位开始取每个位组成radix数组；
     * ③. 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     * @param a	 待排序数组
     */
    public static void radixSort(int[] a){
        if (a.length <= 1) return;
        // 取得数组中最大的数，并取得位数
        int max = 0;
        for (int i = 0; i< a.length;i++){
            if (max < a[i])
                max = a[i];
        }
        int maxDigit = 1;
        while(max / 10 > 0){
            maxDigit++;
            max /= 10;
        }
        // 申请一个桶空间
        int[][] buckets = new int[10][a.length];
        int base = 10;
        // 从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++){
            int[] bktLen = new int[10]; //存储各个桶中存储元素的数量
            // 将所有元素分配到桶中
            for (int j = 0; j < a.length; j++){
                int whichBucket = (a[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = a[j];
                bktLen[whichBucket]++;
            }
            // 将不同桶里数据挨个捞出来，为下一轮高位排序做准备，由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for (int b = 0; b < buckets.length; b++){
                for (int p = 0; p < bktLen[b]; p++)
                    a[k++] = buckets[b][b];
            }
            base *= 10;
        }
    }
}
