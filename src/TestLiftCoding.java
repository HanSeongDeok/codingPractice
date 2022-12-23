class Fruit{
    public String fruit;
    public static final Fruit APPLE = new Fruit();
    public static final Fruit BANANA = new Fruit();
    public static final Fruit PEACH = new Fruit();
    public static final Fruit PEACH2 = new Fruit();

    Fruit(){
        this.fruit = "GOODAPPLE";
    }

}
enum Company{
    GOOD("좋다",1),
    BED("나쁘다",2),
    NICE("굿이다",3);

    private String name;
    private int number;
    Company(String name, int number){
        this.name = name;
        this.number = number;
    }
    public String takeName(){
        return this.name;
    }
    public int takeNumber(){
        return this.number;
    }
}

public class TestLiftCoding{
    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        System.out.println(Fruit.APPLE);
    }
}
