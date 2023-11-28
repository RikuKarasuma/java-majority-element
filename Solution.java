class Solution {

    /**
    * Given an array nums of size n, return the majority element.
    *
    * The majority element is the element that appears more than ⌊n / 2⌋ times. 
    * You may assume that the majority element always exists in the array.
    *
    * Example 1:
    * Input: nums = [3,2,3]
    *
    * Output: 3
    *
    * Example 2:
    * Input: nums = [2,2,1,1,1,2,2]
    *
    * Output: 2 
    */
    public int majorityElement(int[] nums) {

        
        final Map<Integer, Long> counters = Arrays.stream(nums)
                                                  .boxed()
                                                  .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        Map.Entry<Integer, Long> mostOccurances = null;
        for (Map.Entry<Integer, Long> keyAndValue : counters.entrySet()) {
            if (mostOccurances == null) {
                mostOccurances = keyAndValue;
            } else if (keyAndValue.getValue() > mostOccurances.getValue()) {
                mostOccurances = keyAndValue;
            }
        }

        return mostOccurances.getKey();
    }
}
