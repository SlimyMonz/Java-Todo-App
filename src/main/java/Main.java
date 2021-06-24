import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ClassName cn = new ClassName();

		System.out.println(cn.getAmount());
		System.out.println("How much?");
		int temp = sc.nextInt();
		cn.setAmount(temp);
		System.out.println(cn.getAmount());

	}
}
