package RobotBoundCircle;

/**
 * Begins at the origin (0,0)
 */
public class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int index = 0;
        /** North = 0
        east = 1
        south = 2
        west = 3
        **/
         int[][] direction = new int[][]{{0,1}, {1,0}, {0, -1}, {-1, 0}};

        for(char i : instructions.toCharArray()) {
            if(i == 'L')
                index = (index + 3) % 4;
            else if(i == 'R')
                index = (index + 1) % 4;
            else {
                x += direction[index][0];
                y += direction[index][1];
            }
        }
        return index != 0 || (x == 0 && y == 0);

    }
}
