https://www.codechef.com/problems/LPUACE05

All submissions for this problem are available.

We define a number as Lovely number if it repeats certain number twice in its binary representation and there is no other bit.

For example, binary representation 10 is “ 1010” . As you can see 10 is repeating exactly twice, so it is a Lovely number.

Another example, binary representation of 21 is “10101”. Here 10 is repeating twice but there is an extra 1 at the end. So, 21 is not a Lovely number.

Your task is to check whether a number is a Lovely number or not. If it is not a lovely number then output “Not Lovely” (quotes for clarification). If it is a lovely number then output the number which is repeating. e.g. 2 (10 in binary) is repeating for a lovely number 10(1010 in binary)For clarification, see test cases.

Input

First line contains n, which signifies number of testcases.

Each of following n lines contains a number b.

Output

Output n lines, output the repeating number if corresponding number is repeating, if not then output “Not Lovely”.

Example

Input:
2
10
33

Output:
2
Not Lovely
Constraints:
1=< t<= 10^3

1 <=Each Number <=10^8
