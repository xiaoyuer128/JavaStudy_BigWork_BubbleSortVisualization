# JavaStudy_BigWork_BubbleSortVisualization
高二java实验期末大作业-冒泡排序可视化
此作业借鉴于王大神   链接如下： https://my.oschina.net/wangmengjun/blog/775056
冒泡排序伪代码：
bubbleSort(A,n)//包含N个元素的0起点数组A 
flag=1;
while(flag){
flag=0;
for(int j=0;j<n-1;j++){
 if(A[j]<A[j-1])
  swap(A[j],A[j-1]);
  flag=1;
}
}
