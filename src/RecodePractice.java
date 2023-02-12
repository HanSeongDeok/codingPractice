public record RecodePractice(String name, int age) {
    public static int newBorn = 0;
    public RecodePractice{
        if(age < 0){
            throw new IllegalArgumentException("Nope");
        }
    }

    public String nameInUpperCase(){
        return name.toUpperCase();
    }

    public static void main(String[] args) {
        RecodePractice test = new RecodePractice("Han", 27);
        System.out.println(test.nameInUpperCase() + ", " + test.age);
        System.out.println(newBorn);
    }
}
