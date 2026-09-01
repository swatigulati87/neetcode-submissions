class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        //Brute Force
        /*int len1 = nums1.length, len2 = nums2.length;
        int[] merged = new int[len1+len2];
        System.arraycopy(nums1, 0, merged, 0, len1);
        System.arraycopy(nums2, 0, merged, len1, len2);
        Arrays.sort(merged);

        int totLen = merged.length;
        if(totLen % 2 == 0)
        {
            return (merged[totLen/2 - 1] + merged[totLen/2]) / 2.0;
        }
        else
        {
            return merged[totLen/2];
        }*/

        //Binary Search O(log(min(m,n)))   
        int len1 = nums1.length, len2 = nums2.length;
        int[] smaller, larger;

        if(len1 < len2) 
        {
            smaller = nums1;
            larger = nums2;
        }
        else
        {
            larger = nums1;
            smaller = nums2;
        }
        int totLen = len1 + len2;
        int start = 0, end = smaller.length;

        while (start<=end)
        {
            int part1 = (start + end) /2;
            int part2 = (totLen+1)/2 - part1;

            int l1 = part1 == 0 ? Integer.MIN_VALUE : smaller[part1 - 1];
            int r1 = part1 == smaller.length ? Integer.MAX_VALUE : smaller[part1];

            int l2 = part2 == 0 ? Integer.MIN_VALUE : larger[part2-1];
            int r2 = part2 == larger.length ? Integer.MAX_VALUE : larger[part2];

            if(l1 <= r2 && l2 <= r1)
            {   //valid partition
                if(totLen % 2 == 0)
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                else
                    return Math.max(l1,l2);
            }

            if(l1>r2)
                end = part1 - 1;
            else
                start = part1 + 1;
        }
        return 0;
    }
}
