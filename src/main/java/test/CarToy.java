package test;

public class CarToy extends Toy{
    @Override
    public String fun() {
        return "Car is fun";
    }

    public static void main(String[] args) {
        Toy carToy1 = new CarToy();
        System.out.println(carToy1.fun());

        Toy carToy2 = new Toy.Builder<>(new CarToy()).build();
        System.out.println(carToy2.fun());
    }
}
