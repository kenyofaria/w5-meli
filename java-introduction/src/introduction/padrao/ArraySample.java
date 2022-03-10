package introduction.padrao;

import java.util.Arrays;

public class ArraySample {

	public static void main(String[] args) {
		// sample1();
		// sample2();
		sample3();

	}

	private static void sample3() {
		int[][] matrix = new int[3][2];
		matrix[0][0] = 30;
		matrix[1][0] = 100;
		matrix[2][0] = 0;

		matrix[0][1] = 5;
		matrix[1][1] = 3;
		matrix[2][1] = 9;
		
		System.out.println(Arrays.deepToString(matrix));

		int[][] m = { 
						{ 3, 2, 7, 9, 8 }, 
						{ 8, 7, 9, 5, 8, 10, 11 }, 
						{ 7, 6, 1, 0, 2, 5 }, 
						{ 3, 7} 
					};
		for (int i = 0; i < m.length; i++) {
			//for (int j = 0; j< m[i].length; j++) {
				System.out.println(Arrays.toString(m[i]));
			//}
		}
	}

	private static void sample2() {
		String[] array = { "kenyo", "joice", "michele", "mauri" };

		System.out.println("array de tamanho " + array.length);
		System.out.println(Arrays.toString(array));
	}

	private static void sample1() {
		int[] array = new int[10];

		array[0] = 20;
		array[1] = 30;
		array[2] = 10;
		array[3] = 90;
		array[4] = 70;
		array[5] = 50;
		array[6] = 30;
		array[7] = 80;
		array[8] = 60;
		array[9] = 40;

		for (int i = 0; i < array.length; i++) {
			System.out.println("valor na posiçao " + i + " = " + array[i]);
		}

		System.out.println(Arrays.toString(array));
	}
}
