http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=179527&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311


一个笑呵呵的三哥，出了道题：自然string comparator。不知道的搜下。就是string 比较的时候考虑里面数字的大小，比如 abc9 < abc123 abc > ab9  因为char比digit重要。写的很顺利，最后run了test case 人家也说没问题。 然后就结束了。结果下了我自己ide跑发现有case 没cover，不知道他怎么想的，求过！求bless。

要的就是这样：
static class NaturalComparator implements Comparator<String> {-google 1point3acres
    /**.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
     * return negative num if l < r
     0  if l == r
     positive if l > r
     */
    public int compare(String l, String r) {}
