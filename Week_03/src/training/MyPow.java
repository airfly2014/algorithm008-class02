package training;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * <p>
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 */
public class MyPow {

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
//        double result = myPow.myPow(2.000, 2);
        double a = 1.00000d;
        System.out.println(1d/1.0);
    }

//    public double myPow(double x, int n) {
//
//        if (n < 0) {
//            x = 1 / x;
//            n = -1 * n;
//        }
//        return pow(x, n);
//
//    }
//
//    private double pow(double x, int n) {
//
//        if(n == 0){
//            return 1;
//        }
//
//        int half = n / 2;
//        int remain = n % 2;
//
//        double temp = pow(x, half);
//        return temp * temp * (remain == 0 ? 1 : x);
//    }



    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 1) return 1;
        if (x == -1) {
            if (n % 2 == 0) return 1;
            else return -1;
        }
        if (n == Integer.MIN_VALUE) return 0;
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        double ret = 1.0;
        while (n > 0) {
            if ((n & 1) != 0)
                ret *= x;
            x = x * x;
            n = n >> 1;
        }
        return ret;
    }

//    public double myPow(double x, int n) {
//
//        if (n == 0) return 1;
//        if (x == 1) return 1;
//        if (x == -1) {
//            if (n % 2 == 0) return 1;
//            else return -1;
//        }
//        if (n == Integer.MIN_VALUE) return 0;
//        if (n < 0) {
//            n = -n;
//            x = 1/x;
//        }
//
//        double ret = 1.0;
//        while (n > 0) {
//            if ((n & 1) != 0)
//                ret *= x;
//            x = x * x;
//            n = n >> 1;
//        }
//        return ret;
//    }
}
