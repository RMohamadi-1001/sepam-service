package ir.navaco.sepam.sepamservicedemo.model.enums;

public class MainTest implements TestA,TestB {

    @Override
    public void test() {
        //System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        TestA.super.test();
    }

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        mainTest.test();
    }
}
