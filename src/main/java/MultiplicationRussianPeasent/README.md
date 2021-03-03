Multiplication Given two positive integers,
return its product using Russian Peasant method of multiplication

Parameters
Input: a (int)
Input: b (int)
Output: int

Constraints
Assume a <= b, and the value of a is N.
Time: O(logN)
Space: O(1)

487, 734--> 357458
846, 908--> 768168


b,   a
x24, 16

x12, 32
x6, 64
3, 128
1, 256
-------------
   384   
1) double A; half B until B = 1
2) ignore the A,B sets where B is even
3) return the sum of A
