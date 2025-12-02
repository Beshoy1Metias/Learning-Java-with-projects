public class MyBinaryFormatPos{
    public static void main(String[] args) {
        
        int number  = 100;
        int decimal = number;
        
        String remainder = "";
        String output = "";
        
        while(decimal!=0){
            
            remainder +=  (decimal % 2);
            decimal = decimal/ 2;
            
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

        System.out.println("*********************************************************");
        System.out.println("*Conversion to binary of a decimal n where 0 <= n < 128 *");
        System.out.println("*********************************************************");
        
        System.out.println("decimal " + number + " equals " + "0b" +output+ " in base 2");

        
    }
}