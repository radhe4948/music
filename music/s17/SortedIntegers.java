import java.util.*;
public class SortedIntegers {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of integers (N): ");
int N = scanner.nextInt();
// Create a TreeSet to store unique integers in sorted order
TreeSet<Integer> sortedIntegers = new TreeSet<>();
System.out.println("Enter " + N + " integers:");
for (int i = 0; i < N; i++) {
int num = scanner.nextInt();
sortedIntegers.add(num); // TreeSet automatically handles sorting and uniqueness
}
// Display the sorted integers
System.out.println("Sorted integers:");
for (int num : sortedIntegers) {
System.out.println(num);
}
scanner.close();
}
}
