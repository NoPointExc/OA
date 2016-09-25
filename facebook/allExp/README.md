http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=187982&page=1#pid2539599

第一题比较常规，给一个数字组成的字符串，输出所有用'+'和'-'组成的表达式：
比如输入： 123
输出：
1 + 2 + 3
1 + 2 - 3
-1 + 2 - 3 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
-123
123
....

第二题，合并邮件列表（后来才知道也是个面经题）
facebook onsite面经题：
Given 1 million email list:
list 1: a@a.com, b@b.com
list 2: b@b.com, c@c.com. From 1point 3acres bbs
list 3: e@e.com
list 4: a@a.com
.... visit 1point3acres.com for more.
Combine lists with identical emails, and output tuples:
(list 1, list 2, list 4) (a@a.com, b@b.com, c@c.com)
(list 3) (e@e.com)-google 1point3acres
. From 1point 3acres bbs

this is a permutation + combinations

二面，3月25日，就一个题. 1point3acres.com/bbs
给定一个N * Ｍ的matrix，同时给定一个矩阵中存在的坐标(x, y)，
求从(x, y)点用k步（要求是正好k步， k >= 0）搜索到(0, 0)点共有多少条路径，
从每一个点往下一个点搜索时，可以上下左右四个方向走。
. From 1point 3acres bbs
比如，下面这个矩阵：
----------
0 0 0 0 0 . 1point3acres.com/bbs
0 0 0 0 0
0 0 0 0 0 
0 0 0 0 0

(x, y) = (1, 1), k = 2，输出为2

很快用dfs写完了，面试官要求用三维dp来做，最后写的也是磕磕绊绊的

anyway，最后technical interview算过了，但是team match只面了一次没match上就给我挂了~或许是真没坑了（算是阿Ｑ精神的心理安慰吧），4月20号通知的~. visit 1point3acres.com for more.

求大米，谢谢各位~
