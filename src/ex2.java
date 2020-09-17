
public class ex2 {
	
	public static void printMultiples(int n, int start, int end) {
		int margin = (n - start % n);
		for (int i = start + margin; i <= end; i += n)
			System.out.println(i);
	}
	
	public static void main(String[] args) {
		printMultiples(3, 1, 100);
	}
}
