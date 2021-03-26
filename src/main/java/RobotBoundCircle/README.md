https://leetcode.com/problems/robot-bounded-in-circle/

On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.


EXAMPLE 1

Input1 : instructions = "GGLLGG"
Output1: true
Explanation1: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.

EXAMPLE 2

Input2 : instructions = "GG"
Output2: false
Explanation2: The robot moves north indefinitely.

EXAMPLE 3

Input3 : instructions = "GL"
Output3: true
Explanation3: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...



Constraints:
- 1 <= instructions.length <= 100
- instructions[i] is 'G', 'L' or, 'R'.