// package whatever; // don't place package name!

/**
 problem: given a math expression, for example, (3*7)+4, determine if
 any parentheses are not necessary 
 account for PEMDAS order
 
 result should be: 3*7+4
 
 as a tree: BFS?
 
      *
    3   7
      +  4
      
example is (((3+8*4)*7)+2)*9
(((m+k*i)*j)+y)*x
m+ k * i => m + z
m+z => p
(p*j)


 z 
    
1. Traverse left to right
2. Add stuff to queue
3. If right paren, do
  3a. reduce subexpression to one op
    
boolean[]  necessaryParant - size number of pairs of paranths

reduce(int, int, operation) => int

 
 number: add to a queue
 operator: add to a queue: 
 
 *
 +
 *
 )
 *
 +
 (
 (
 (
 
 (P)
 E
 M
 D
 A
 S
      root
      
    (3+8...)
    /
    
    

Traverse expression, if the NEXT operation has less or equal priority
to our current, then we do NOT need paranthesis pair





