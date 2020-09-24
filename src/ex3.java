import java.util.Scanner;

public class ex3 {
	
	public static int fat(int n) {
		if (n <= 1) return 1;
		return n * fat(n - 1);
	}
	
	public static void main(String[] args) {
		System.out.print("Digite o valor: ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		System.out.println("Fatorial: " + fat(input));
		scan.close();
	}
}
