package proxy;

public class Cooker implements Cook {
    @Override
    public void dealWithFood() {
        System.out.println("deal with food");
    }

    @Override
    public void cook() {
        System.out.println("cook");
    }
}
