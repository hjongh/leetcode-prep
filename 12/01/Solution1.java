/**
 * Times out. I'm pretty sure its correct though. It's just horribly inefficient... could there possibly be a better
 * way?
 */
class Solution {
    class PairComparator implements Comparator<List<Integer>> {
        public int compare(List<Integer> p1, List<Integer> p2) {
            return (p1.get(0) + p1.get(1)) - (p2.get(0) + p2.get(1));
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new PairComparator());
        for (int n1: nums1) {
            for (int n2: nums2) {
                pq.add(new ArrayList<Integer>(Arrays.asList(n1, n2)));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (pq.size() > 0) {
                ans.add(pq.poll());
            }
        }
        return ans;
    }
}