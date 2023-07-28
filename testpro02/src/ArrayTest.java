public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 4, 5, 9, 7, 8};

        Sort.sort(arr);

        for (int a : arr) {
            System.out.println(a);
        }
    }
}
