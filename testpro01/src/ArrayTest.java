public class ArrayTest {
    public static void main(String[] args) {
        String name = "hello";
        change(name);
        System.out.println(name);
    }
    public static void change(String name){
        name=new String("world");
    }
}
