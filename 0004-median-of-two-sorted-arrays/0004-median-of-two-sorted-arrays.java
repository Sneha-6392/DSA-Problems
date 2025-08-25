class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int k=0;
        int[] merge= new int[nums1.length+nums2.length];
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                merge[k]=nums1[i];
                i++;
                k++;
            }
            else{
                merge[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<nums1.length){
            merge[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            merge[k]=nums2[j];
            j++;
            k++;
        }
        double median=0.0;
        int mid=merge.length/2;
        if(merge.length%2!=0){
            median=merge[mid];
        }
        else{
            median=(merge[mid]+merge[mid-1])/2.0;
        }
        return median;
    }
}