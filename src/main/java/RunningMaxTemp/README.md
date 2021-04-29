For a given number, how long has it been larger than
all previous numbers in temperature array?

Given a Timeseries that keeps information about Temperature readings for a city,
return a Timeseries that tells you, for a given day,
how long has its value been the largest running value.

eg: For temperature readings       temperatures = [30,50,60,20,10,40,60,90],
<br>the transformed timeseries would be               [ 1, 2, 3, 1, 1, 3, 7, 8]

[1,1,1,1...]
<br>maxTemp = [1,2,3]
<br>maxPointer = 2
<br>max = 50
<br>previousLargerNumber = 0

Need some way to keep track of previous larger number