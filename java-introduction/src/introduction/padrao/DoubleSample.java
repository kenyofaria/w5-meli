package introduction.padrao;

import java.text.DecimalFormat;

public class DoubleSample {

	public static void main(String args[]) {
		double salario = 30000.50;
		System.out.println(salario);
		DecimalFormat df = new DecimalFormat("#,###.00");
		System.out.println(df.format(salario));
	}
}
