(Google Onsite) Array elements subtraction Game
Imagine you have an array as [2， 7], subtract 2 from 7 and append result to the original array -> [2,7,5]

[2， 7， 5] -> [2， 7， 5，3]
[2，7，5，3] -> [2，7，5，3，1] or [2，7，5，3，4]

[2，7，5，3，1] -〉[2，7，5，3，1， 6] or [2，7，5，3，1， 4]
[2，7，5，3，1， 4] ->[2，7，5，3，1， 6， 4] or [2，7，5，3，1，4，6]

[2，7，5，3，4] -〉 [2，7，5，3，4，1] -〉[2，7，5，3，4，1，6]

Subtract between elements in the array until you cannot do so( no new element generated), The bold one are final results

The question is to ask you output all the results in List<List<res>> format

https://discuss.leetcode.com/topic/59478/google-onsite-array-elements-subtraction-game
