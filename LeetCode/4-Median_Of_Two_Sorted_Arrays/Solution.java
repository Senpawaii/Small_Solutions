public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1_size = nums1.length;
        int nums2_size = nums2.length;
        int[] smallest_array;
        int[] largest_array;
        if(nums1_size > nums2_size) {
            smallest_array = nums2;
            largest_array = nums1;
        } else {
            smallest_array = nums1;
            largest_array = nums2;
        }

        int totalElements = nums1_size + nums2_size;

        int start = 0;
        int end = smallest_array.length;
        int partitionX = 0;
        int partitionY = 0;
        
        int maxLeftX = -99999999;
        int minRightX = 99999999;
        int maxLeftY = -99999999;
        int minRightY = 99999999;

        boolean flag = true;

        while(flag) {
            partitionX = (start + end)/2;
            partitionY = (nums1_size + nums2_size + 1)/2 - partitionX;
            
            if(partitionX > 0) {
                maxLeftX = smallest_array[partitionX - 1];
                if(partitionX < smallest_array.length) {
                    minRightX = smallest_array[partitionX];
                } else if(partitionX == smallest_array.length) { minRightX = 99999999; }
            } else {
                maxLeftX = -99999999;
                if(smallest_array.length != 0) { minRightX = smallest_array[0]; }
            }
            if(partitionY > 0) {
                maxLeftY = largest_array[partitionY - 1];
                if(partitionY < largest_array.length) {
                    minRightY = largest_array[partitionY];
                } else if(partitionY == largest_array.length) { minRightY = 99999999; }
            } else {
                maxLeftY = -99999999;
                if(largest_array.length != 0) { minRightY = largest_array[0]; }
            }

            switch(assertConditions(maxLeftX, maxLeftY, minRightX, minRightY)) {
                case 1:
                    //conditions met, we found our partition barrier
                    flag = false;
                    break;
                case 2:
                    // Need to shift binary search to the right, increasing the starting point...
                    start = partitionX + 1;
                    break;
                case 3:
                    end = partitionX - 1;
                    break;
            } 
        }
        return computeMedian(totalElements, maxLeftX, maxLeftY, minRightX, minRightY );
    }
    public static double computeMedian(int totalSize, int maxLeftX, int maxLeftY, int minRightX, int minRightY) {
        if(totalSize % 2 != 0) {
            return Math.max(maxLeftX, maxLeftY) * 1.0000;
        } else {
            double res = Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY);
            return (res / 2) * 1.0000;
        }
    }

    public static int assertConditions(int maxLeftX, int maxLeftY, int minRightX, int minRightY) {
        if(maxLeftX <= minRightY) {
            if(maxLeftY <= minRightX) {
                return 1;
            }
            return 2;
        }
        return 3;
    }
    
    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        int[] arr1 = {1,3,8,9,15};
        int[] arr2 = {7,11,18,19,21,25};
        System.out.println(findMedianSortedArrays(arr1, arr2));

        System.out.println("Test Case 2:");
        int[] arr3 = {23,26,31,35};
        int[] arr4 = {3,5,7,9,11,16};
        System.out.println(findMedianSortedArrays(arr3, arr4));

        System.out.println("Test Case 3:");
        int[] arr5 = {};
        int[] arr6 = {3,5,7};
        System.out.println(findMedianSortedArrays(arr5, arr6));

        System.out.println("Test Case 4:");
        int[] arr7 = {1,3};
        int[] arr8 = {2};
        System.out.println(findMedianSortedArrays(arr7, arr8));

        System.out.println("Test Case 5:");
        int[] arr9 = {1,2};
        int[] arr10 = {3, 4};
        System.out.println(findMedianSortedArrays(arr9, arr10));

    }
}
