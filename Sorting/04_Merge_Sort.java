class Solution {
    public int[] mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        int[] temp = new int[nums.length];
        mergeSortHelper(nums, temp, 0, nums.length - 1);
        return nums;
    }

    private void mergeSortHelper(int[] nums, int[] temp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortHelper(nums, temp, left, mid);
        mergeSortHelper(nums, temp, mid + 1, right);
        merge(nums, temp, left, mid, right);
    }

    private void merge(int[] nums, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) temp[i] = nums[i];
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) nums[k++] = temp[i++];
            else nums[k++] = temp[j++];
        }
        while (i <= mid) nums[k++] = temp[i++];
        while (j <= right) nums[k++] = temp[j++];
    }
}
