https://leetcode.com/problems/daily-temperatures/

Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

EXAMPLE 1

Input1 : T = [73, 74, 75, 71, 69, 72, 76, 73]
Output1: [1, 1, 4, 2, 1, 1, 0, 0]
Explanation1: On day 0, 73 deg, you have to wait 1 day until a warmer temp (74 deg on day 1). On day 1, 74 deg, you have to wait 1 day until a warmer temp, (75 deg on day 2). On day 2, 75 deg, you have to wait 4 days you have to wait 4 days until a warmer temp (76 deg on day 6).


Constraints:
- The length of temperatures will be in the range [1, 30000].
- Each temperature will be an integer in the range [30, 100].
