// 用两个二分法来做：
// outer二分（quick select）: select the k th element, 用 MID 值逼近。一共lg(max-min)次。
// inner二分：for n row:
//           每一行具体COUNT多少个小于MID， 用[mid of row]去逼近MID在这一行的位置。
//           n row, m col, 所以运行N次，每一次M个数字，所以总运行次数是 nlogm
// 总复杂度为O(nlogm *  logX), m=n, 所以O(nlogn *  logX)
