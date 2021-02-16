package lanQiao2013._猜年龄;

import java.util.HashSet;
import java.util.Set;

/**
 * 第一题：猜年龄
 * 题目描述
 *      美国数学家维纳(N.Wiener)智力早熟，11岁就上了大学。他曾在1935~1936年应邀来中国清华大学讲学。
 *     一次，他参加某个重要会议，年轻的脸孔引人注目。于是有人询问他的年龄，他回答说：
 *     “我年龄的立方是个4位数。我年龄的4次方是个6位数。这10个数字正好包含了从0到9这10个数字，每个都恰好出现1次。”
 *     请你推算一下，他当时到底有多年轻。
 *
 *      n*n*n = ? (4)
 *      n*n*n*n = ? (6)
 *
 *     通过浏览器，直接提交他那时的年龄数字。
 *     注意：不要提交解答过程，或其它的说明文字。
 *
 *
 *     知识点：
 *     1.int-->String   直接在int上加一个空串；
 *     2.String.charAt()    返回的是下标对应的字符（char类型的数据）
 *     3.HashSet    可以去重
 */
public class Main {
    public static void main(String[] args) {
        for (int n = 11; n <= 100 ; n++) {
            int i = n * n * n;                                  //1.计算年龄立方的值
            int i2 = n * n * n * n;                             //2.计算年龄4次方的值
            String s = i + "";                                  //3.将年龄的立方转化为String类型
            String s2 = i2 + "";                                //4.将年龄的4次方转化为String类型
            if (s.length()==4 && s2.length()==6){               //5.判断年龄立方是否为4位数，年龄4次方是否为6位数
                Set<Character> set = new HashSet<Character>();  //6.创建set集合对象，用作于去除重复值
                String s3 = s+s2;                               //7.合并年龄立方和年龄4次方
                for (int j = 0; j < s3.length(); j++) {
                    set.add(s3.charAt(j));                      //8.遍历合并后的字符串，将每个字符串中的字符添加到set集合中
                }
                if (set.size()==10) {                           //9.若集合的size大小为10，说明符合每个数字都恰好出现1次的条件，并输出年龄n
                    System.out.println(n);
                }
            }
        }
    }

    /**
     * 优化过后的代码
     *
     * public static void main(String[] args) {
     *         for (int n = 11; n <= 100 ; n++) {
     *             String s = (n * n * n)+"";                               //计算年龄立方的值，并将年龄的立方转化为String类型
     *             String s2 = (n * n * n * n)+"";                          //计算年龄4次方的值，并将年龄的4次方转化为String类型
     *             if (s.length()==4 && s2.length()==6 && check(s+s2)){     //判断年龄立方是否为4位数，年龄4次方是否为6位数，将两个String的值合并，作为参数，判断是否符合每个数字都恰好出现1次的条件
     *                 System.out.println(n);                               //若条件都成立，那么输出年龄
     *             }
     *         }
     *     }
     *     static Set<Character> set;                                       //创建set对象
     *     private static boolean check(String s) {
     *         set = new HashSet<>();                                       //初始化set
     *         for (int i = 0; i < s.length(); i++) {
     *             set.add(s.charAt(i));                                    //遍历合并后的字符串，将每个字符串中的字符添加到set集合中
     *         }
     *         return set.size()==10;                                       //判断set的size是否为10.若是则返回true，若不是则返回false
     *     }
     */
}
