package AsteroidCollision;

import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        //Use stack and check the direction of the asteroids
        Stack<Integer> asteroidStack = new Stack<>();

        for(int i = 0; i < asteroids.length; i++) {
            if(asteroidStack.isEmpty() || asteroids[i] > 0) {
                asteroidStack.push(asteroids[i]);
            }
            else {
                while(true){
                    int top = asteroidStack.peek();
                    if(top < 0){
                        asteroidStack.push(asteroids[i]);
                        break;
                    }
                    else if(top == -asteroids[i]){
                        asteroidStack.pop();
                        break;
                    }
                    else if(top > -asteroids[i]) {
                        break;
                    }
                    else{
                        asteroidStack.pop();
                        if(asteroidStack.isEmpty()){
                            asteroidStack.push(asteroids[i]);
                            break;
                        }

                    }
                }
            }
        }

        return asteroidStack.stream()
                .mapToInt(x->x)
                .toArray();
    }
}
