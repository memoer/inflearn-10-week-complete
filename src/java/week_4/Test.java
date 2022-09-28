package week_4;

public class Test {
  public static void main(String[] args) {
    int num1 = 7;
    String b1 = Integer.toBinaryString(num1);
    int num2 = num1 ^ (1 << 1); // 1<<1 -> 10
    String b2 = Integer.toBinaryString(num2);
    System.out.println(b1 + ", " + b2); // 111, 101

    int num3 = 5;
    String b3 = Integer.toBinaryString(num3);
    int num4 = num3 ^ (1 << 1); // 1<<1 -> 10
    String b4 = Integer.toBinaryString(num4);
    System.out.println(b3 + ", " + b4); // 101, 111
  }
}
