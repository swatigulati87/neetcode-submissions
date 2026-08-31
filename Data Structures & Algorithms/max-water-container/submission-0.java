class Solution {
    public int maxArea(int[] heights) {
        
        //Brute Force Method
        /*int area = 0;
        for (int i = 0; i < heights.length; i++)
        {
            for (int j = i+1; j < heights.length; j++)
            {
                area = Math.max(area, Math.min(heights[i], heights[j]) * (j-i));
            }
        }
        return area;*/

        int start = 0, end = heights.length - 1, area  = 0;
        while (start<end) {
            int temp = Math.min (heights[start], heights[end]) * (end - start);
            area = Math.max(area,temp);
            if(heights[start] <= heights[end]) {
                start++;
            }
            else{
                end--;
            }
        }
        return area;
    }
}
