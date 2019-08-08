import java.util.*; 
public class Question3 {

	public static void main(String[] args) {
		int array[] = new int[500];
		System.out.println("Enter the nth smallest number:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Random rn = new Random();
		for (int i = 0; i < 500; i++) {
//			array[i] = (int) (Math.random() * i);
			array[i] = rn.nextInt(1000);
			System.out.println("Random number " + i + " is " + array[i]);
		}
		 System.out.println(n+"th " +"smallest number is: "+findNthSmallestNumber(array, n ));

	}
	
	
	public static int findNthSmallestNumber(int arr[], int n) {
		int element = 0;
		Arrays.sort(arr);
		
		element = arr[n];
		
    System.out.println("Random numbers generated in ascending order are: "+Arrays.toString(arr));
		
		return element;
	}

}
