package ss22_structural_design_pattern.thuc_hanh.proxy;

public class Main {
    public static void main(String[] args) {
        MathCalculatorFroxy mathCalculatorFroxy = new MathCalculatorFroxy();
        double result = mathCalculatorFroxy.add(1, 2);
        System.out.println("1 + 2 = " + result);

        result = mathCalculatorFroxy.add(2,Double.MAX_VALUE);
        System.out.println("2 + MAX_VALUE = " + result);
    }
}
