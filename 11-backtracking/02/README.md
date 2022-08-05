So now I'm thinking back to the Berkeley CS material. There are different kinds of recursive problems... ones where you just find one optimal solution, or others where you brute force everything. This is a recursive enumeration problem where we want to enumerate all possibilities. So we start with empty data and generate larger and larger solutions.

Time complexity is `O(2^n)`. Space complexity is `O(n * 2^n)`.

How to represent the solution space? Need to generate all the strings.