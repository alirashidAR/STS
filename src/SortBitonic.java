import java.util.*;

public class SortBitonic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of elements
        int[] array = new int[n]; // dynamic array size

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(array[i]);
        }

        arr.sort(Comparator.naturalOrder());
        Arrays.sort(array);
        Arrays.sort(arr.toArray());
        for( int a : arr){
            System.out.println(a);
        }
    }
}
