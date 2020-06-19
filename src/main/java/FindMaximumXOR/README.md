Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.

00101 
11001
-----
11100
XOR: 11100 => 28 

1111
0011
1100

2,3,5,8,10,25 =  O(N)


O(N^2) - we can keep track running max. compare each element 
XORd with all other elements against running max
-Optimization: compare only if the number is greater than our current element

Tries?
We may somehow use a trie to capture pre or postfix of the binary representation of the XORd result?
or the numbers?