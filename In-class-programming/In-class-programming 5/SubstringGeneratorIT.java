public class SubstringGeneratorIT
{
	public static void main(String[] args)
	{
		if(args.length<1){
			System.out.print("Use java SubstringGeneratorIT <input>");
			return;
		}
		String input = args[0];
		int dim = 1;
		int size = input.length()*(input.length()+1);
		size = size/2;
		String[] v = new String[size];
		int counter=0;
		while(dim<=input.length())
		{
			for(int i=0; i+dim<=input.length(); i++)
			{
				v[counter]= input.substring(i, i+dim);
				counter++;
			}
			dim++;
		}
		for(int j =0; j<size; j++)
		{
			System.out.print(" "+ v[j]);
		}
		
	}
	
}