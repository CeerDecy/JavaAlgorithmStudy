package lanQiao2013._组素数;

import java.util.HashSet;
import java.util.Set;

/**
 * 第二题：组素数
 * 题目描述
 *     素数就是不能再进行等分的数。比如：2 3 5 7 11 等。
 *     9 = 3 * 3 说明它可以3等分，因而不是素数。
 *     我们国家在1949年建国。如果只给你 1 9 4 9 这4个数字卡片，可以随意摆放它们的先后顺序（但卡片不能倒着摆放啊，我们不是在脑筋急转弯！），
 *     那么，你能组成多少个4位的素数呢？
 *     比如：1949，4919 都符合要求。
 *
 *
 * 请你提交：能组成的4位素数的个数，不要罗列这些素数!!
 * 注意：不要提交解答过程，或其它的辅助说明文字。
 *
 * 总结：
 *      1.全排列
 *      2.判断素数的方法
 */

public class Main {

    private static int ans = 0;                                 //定义一个变量ans，用来记录素数的个数

    public static void main(String[] args) {
        int[] arr = {1,9,4,9};                                  //定义一个数组{1,9,4,9}
        f(0,arr);
                                                                //各个数字进行交换,并且进行判断
        System.out.println(ans);                                //输出素数的个数
    }

    private static void f(int n, int[] arr) {
        check(arr);                                             //判断arr，是否为素数
        for (int i = n; i < arr.length; i++) {
            int k = arr[n];
            arr[n] = arr[i];
            arr[i] = k;                                         //交换两个数的位置

            f(n+1,arr);                                       //将新组成的数作为新的数组继续交换

            k = arr[n];
            arr[n] = arr[i];
            arr[i] = k;                                         //交换完成后回到最初位置，以便下一个循环做交换
        }
    }
    static Set<Integer> set = new HashSet<>();
    public static void check(int[] arr){
        int val = arr[0]*1000+arr[1]*100+arr[2]*10+arr[3];      //将int数组转化成一个4位数的int整数
        if (!set.contains(val)){                                //判断set中是否含有将要判断的整数，若没有则运行下面的代码
            boolean flag = true;                                //定义一个boolean值用作标记是否为素数
            set.add(val);                                       //将这个整数添加到set中去
            for (int i = 2; i < Math.sqrt(val); i++) {
                if (val%i==0){                                  //将val从2开始除，若有余数为0说明这个数已经被整除
                    flag = false;                               //将flag标记为false，并且跳出循环，说明这个数不为素数
                    break;
                }
            }
            if (flag) {                                         //循环结束后，若flag为true说明这个数是素数，若flag为false说明这个数不是素数
                System.out.println(val);
                ans++;                                          //如果是素数，那么ans+1
            }
        }
    }
}
