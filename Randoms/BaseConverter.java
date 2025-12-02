public class BaseConverter{
    public static void main(String[] args) {
        
		int base =7;
        int number  = 256;
		
        int decimal = number;
        
        String remainder = "";
        String output = "";
        
        while(decimal!=0){
            
            remainder +=  (decimal % base);
            decimal = decimal/ base;
            
        }
        if(remainder.length()<8){
            for(int i = 8 - remainder.length(); i >0; i--){
                remainder += 0;

            }
        }
        for (int i = remainder.length()-1; i>= 0; i--) {
            output += remainder.charAt(i);
        }
        String s = output.substring(0, 4);
        String ss = output.substring(4, 8);
        output = s+"_"+ss;
        
        System.out.println("decimal " + number + " equals "+output+ " in base "+base);

        
    }
}