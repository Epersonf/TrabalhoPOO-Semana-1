
public class ex4 {
	public static void printFibo(int a, int b, int max) {
		int sum = a + b;
		System.out.print(a + " -> ");
		if (sum >= max) {
			System.out.print(b);
			return;
		}
		printFibo(b, sum, max);
	}
	
	public static void main(String[] args) {
		printFibo(0, 1, 100);
	}
}
