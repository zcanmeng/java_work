package com.algorithm.al01;

public class Sparse {

    /**
     * 转换为稀疏表
     * @param arr
     * @return
     */
    public int[][] changeSparse(int[][] arr){
        int sum=0;

        //遍历所有有数据的位置个数
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if (arr[i][j]!=0){
                    sum++;
                }
            }
        }

        //创建稀疏列表
        int[][] result = new int[sum+1][3];

        //第一行为表信息
        result[0][0]=arr.length;
        result[0][1]=arr[0].length;
        result[0][2]=sum;

        //定义行数
        int row=1;

        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if (arr[i][j]!=0){
                    result[row][0]=i;
                    result[row][1]=j;
                    result[row][2]=arr[i][j];
                    row++;
                }
            }
        }


        return result;
    }

    public int[][] changeArr(int[][] sparse){
        int[][] arr=new int[sparse[0][0]][sparse[0][1]];

        for (int i = 1;i<sparse.length;i++){
            arr[sparse[i][0]][sparse[i][1]]=sparse[i][2];
        }

        return arr;

    }
}
