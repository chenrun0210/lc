package test;

public class TestAssert {
    public static void main(String[] args) {
        String value = "";
        assert(value != null && value.length() > 0) : "invalid value for argument";
        System.out.println("---");
    }
}
