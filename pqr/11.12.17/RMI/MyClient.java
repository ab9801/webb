import java.rmi.*;
import java.util.Scanner;

public class MyClient{

public static void main(String args[]){	
	try
	{
		Adder stub=(Adder)Naming.lookup("rmi://localhost:5000/dee");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two numbers:");
		int a,b;
		a=input.nextInt();
		b=input.nextInt();
		System.out.println("Their sum is:"+stub.add(a,b));
	}
	catch(Exception e){System.out.println(e);}
}
}
