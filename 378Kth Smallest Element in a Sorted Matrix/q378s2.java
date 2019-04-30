这题我们也可以用二分查找法来做，我们由于是有序矩阵，那么左上角的数字一定是最小的，而右下角的数字一定是最大的，所以这个是我们搜索的范围，然后我们
算出中间数字mid，由于矩阵中不同行之间的元素并不是严格有序的，所以我们要在每一行都查找一下mid，我们使用upper_bound，这个函数是查找第一个大于目标数
的元素，如果目标数在比该行的尾元素大，则upper_bound返回该行元素的个数，如果目标数比该行首元素小，则upper_bound返回0, 我们遍历完所有的行可以找出
中间数是第几小的数，然后k比较，进行二分查找，left和right最终会相等，并且会变成数组中第k小的数字。举个例子来说吧，比如数组为:
[1 2
12 100]
k = 3
那么刚开始left = 1, right = 100, mid = 50, 遍历完 cnt = 3，此时right更新为50
此时left = 1, right = 50, mid = 25, 遍历完之后 cnt = 3, 此时right更新为25
此时left = 1, right = 25, mid = 13, 遍历完之后 cnt = 3, 此时right更新为13
此时left = 1, right = 13, mid = 7, 遍历完之后 cnt = 2, 此时left更新为8
此时left = 8, right = 13, mid = 10, 遍历完之后 cnt = 2, 此时left更新为11
此时left = 11, right = 12, mid = 11, 遍历完之后 cnt = 2, 此时left更新为12
循环结束，left和right均为12，任意返回一个即可。
查找一行需要log(n) ，有n行所以nlog(n)，最坏下需要查找log(X)次（X= int最大值的时候logX仅仅才为32），X为最大最小数差值。  
所以总复杂度为O(nlogn *  logX)
