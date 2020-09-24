import java.util.Scanner;

public class ex5 {
	
	public static void evaluate(int x) {
		System.out.print(x + " -> ");
		if (x <= 1) return;
		evaluate((x % 2==0) ? x/2 : (3*x+1) );	
	}	
	
	public static void main(String[] args) {
		System.out.print("Digite o valor: ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		evaluate(input);
		scan.close();
	}
	
}
