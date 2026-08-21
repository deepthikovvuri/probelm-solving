import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();
        boolean duplicate = false;

        for (int i = 0; i < n; i++) {

            if (set.contains(arr[i])) {
                System.out.println("Duplicate found: " + arr[i]);
                duplicate = true;
                break;
            }

            set.add(arr[i]);
        }

        if (!duplicate) {
            System.out.println("No duplicates found");
        }

        sc.close();
    }
}














