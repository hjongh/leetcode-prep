Uh... put all the pairs in a heap, ordered by the sum of the pair (ascending), and withdraw k pairs.

Time complexity: `O(n1 * n2 + k * log(n1 * n2))`. First factor is for building the heap, second is for withdrawing k smallest pairs from the eap.

# Take 2

Okay there are many many ways to optimize this, I'm realizing, from looking at my old submissions.

First is you can make a max-heap instead of a min-heap, and then keep it max at size k. So that reduces the Big O to `O(n1 * n2 + k * log(min(n1 * n2, k)))`.

Second is you know `list1[x]*list2[y]` will always be less than `list1[x+1]*list2[y]` or `list1[x]*list2[y]`. This is because the lists are sorted. So you can really keep the size of the heap small.