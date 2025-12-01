public class SubstringGeneratorIT
{
	public static void main(String[] args)
	{
		String input = args[0];
		String input1 = input;
		String input2 = input;
		int size = input.length() * (input.length()+1);
		size = size/2;
		String[] v = new String[size];
		int sizeofinput=input.length();
/*
		for(int i = 0; i<sizeofinput; i++)
		{
			v[i]= input.substring(0, 1);
			input = input.substring(1, input.length());
			
		}*/
		for(int i = 0; i<size; i++)
		{
			for(int j = i; j<sizeofinput; j++){
				v[i]=input1.substring(i, j);
				
			}
		}

		
		
		for(int i =0; i<size; i++){
			System.out.println(v[i]);
		}
	}
}