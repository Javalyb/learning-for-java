package priv.lyb.study.base.operator;

/**
 * @Author: lyb
 * @Description:
 * @Date: 02:12 2022/01/08
 * +=操作符会进行隐式自动类型转换，a+=b将加操作的结果类型转换为持有结果类型，而a=a+b则不会进行自动类型转换
 */
public class Test1 {
    public static void main(String[] args) {

        byte a = 1;
        byte b = 1;
        // b = a + b;
        b += a;

        short s1 = 1;
        //s1 = s1 + 1; //short类型在进行运算时会自动提升为int类型，s1+1的运算结果是int类型，s1为short类型，编译会报错

        //+=操作符会对右边的表达式结果强转为左边的数据类型
        short s2 = 1;
        s2 += 1;

    }
}
