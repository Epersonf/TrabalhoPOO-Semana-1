import java.util.Scanner;

public class ex5 {
	
	public static void evaluate(int x) {
		if (x == 1) return;
		int newX = x;
		
		if (x % 2 == 0) newX = x/2;
		if (x % 2 != 0) newX = 3*x + 1;
		System.out.print(newX);
		
		if (newX != 1) System.out.print(" -> ");
		else return;
		
		evaluate(newX);		
	}	
	
	public static void main(String[] args) {
		System.out.print("Digite o valor: ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		evaluate(input);
	}
	
}
