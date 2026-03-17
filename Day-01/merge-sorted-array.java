// Problem: Merge Sorted Array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;    //nums1 pointer 
        int j = n-1;    //nums2 pointer 
        int k = m+n-1;  //final position of m+n

        while (i >= 0 && j >= 0) {
           if (nums1[i] > nums2[j]) {
               nums1[k] = nums1[i];
               i--;
            } else {
               nums1[k] = nums2[j];
               j--;
            }
            k--;
        }

        while (j >= 0) {           //by any chance if nums2 still have elements
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
