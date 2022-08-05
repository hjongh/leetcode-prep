/**
 * This was my final submission for when I last solved this problem. It's really fast... but why is there so much code?
 *
 *
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) return ans;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        Set<Pair> seen = new HashSet<>();
        Pair genesisPair = new Pair(0, 0, nums1[0] + nums2[0]);
        minHeap.add(genesisPair);
        seen.add(genesisPair);
        int maxNumPairs = nums1.length * nums2.length;
        int numPairsInAns = Math.min(k, maxNumPairs);

        while (ans.size() != numPairsInAns) {
            Pair p = minHeap.poll();
            addPairToAns(p, ans, nums1, nums2);

            int nextP1Index = p.i1 + 1;
            if (nextP1Index < nums1.length) {
                addPairToHeapIfNotSeen(new Pair(nextP1Index, p.i2, nums1[nextP1Index] + nums2[p.i2]), seen, minHeap);
            }
            int nextP2Index = p.i2 + 1;
            if (nextP2Index < nums2.length) {
                addPairToHeapIfNotSeen(new Pair(p.i1, nextP2Index, nums1[p.i1] + nums2[nextP2Index]), seen, minHeap);
            }
        }
        return ans;
    }

    private void addPairToHeapIfNotSeen(Pair p, Set<Pair> seen, PriorityQueue<Pair> heap) {
        if (!seen.contains(p)) {
            heap.add(p);
            seen.add(p);
        }
    }

    private void addPairToAns(Pair p, List<List<Integer>> ans, int[] nums1, int[] nums2) {
        List<Integer> pAsList = new ArrayList<>();
        pAsList.add(nums1[p.i1]);
        pAsList.add(nums2[p.i2]);
        ans.add(pAsList);
    }
}

class Pair implements Comparable<Pair> {
    int i1;
    int i2;
    int sum;

    public Pair(int i1, int i2, int sum) {
        this.i1 = i1;
        this.i2 = i2;
        this.sum = sum;
    }

    @Override
    public int compareTo(Pair other) {
        return this.sum - other.sum;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof Pair)) return false;

        Pair that = (Pair)obj;
        return this.i1 == that.i1 && this.i2 == that.i2;
    }

    @Override
    public int hashCode(){
        return this.i1 * 31 + this.i2;
    }
}