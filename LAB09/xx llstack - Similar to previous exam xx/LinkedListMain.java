import java.util.Scanner;

public class LinkedListMain
{
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	LinkedListStack stack = new LinkedListStack();
	while(in.hasNext())
	{
		stack.push(in.next());
	}
	int SIZE = stack.size();
	for(int i=0; i<SIZE; i++)
	{
		System.out.println(stack.removeFirst());
	}
	}
}