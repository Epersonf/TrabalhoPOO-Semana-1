public class ex1 {
	
	static int sum(int n) {
		//return (n)*(n + 1)/2;
		int sum = 0;
		for (int i = 1; i <= n; i++)
			sum += i;
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(sum(100));
	}
}
