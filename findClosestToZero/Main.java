import java.util.Arrays;

public class Main{

     public static void main(String []args){
        
        findClosestToZero(new int[]{-100, -40, -10, 20, 40, 60, 110});
        findClosestToZero(new int[]{89, 59, -90, 85, 39, 12, -100});
        findClosestToZero(new int[]{});
        findClosestToZero(new int[]{11, 90});
	findClosestToZero(new int[]{-9,80,38});
	findClosestToZero(new int[]{-9,80,38,10,-10,40,-40});
     }
     public static void findClosestToZero(int[] array){
     
	//array has either no or 1 element    
         if(array.length == 0 || array.length == 1){
             System.out.println("It has less than 2 elements, no solution...");
             return;
         }
	//array has only 2 elements
         else if(array.length == 2){
	     System.out.printf("Sum of %d, %d is %d\n",array[0], array[1], array[0]+array[1]);
	     return;
	 }
            
	//array has more than 2 elements
         Arrays.sort(array);
         int finalIndexStart = 0,
             finalIndexEnd = array.length-1,
             finalSum = array[0]+array[array.length-1];
         
         int tmpIndexStart = 0,
             tmpIndexEnd = array.length-1,
             tmpSum = array[0]+array[array.length-1];
             
         for(int counter=0; counter<array.length; counter++){
             
             if(tmpSum > 0){
                 tmpIndexEnd--;
                 tmpSum = array[tmpIndexStart]+array[tmpIndexEnd];
             }
             else if(tmpSum < 0){
                 tmpIndexStart++;
                 tmpSum = array[tmpIndexStart]+array[tmpIndexEnd];
             }
             
             if(Math.abs(tmpSum) < Math.abs(finalSum)){
                 finalIndexStart = tmpIndexStart;
                 finalIndexEnd = tmpIndexEnd;
             }
             if(tmpSum==0){
                 break;
             }
         }
      System.out.printf("Sum of %d and %d is %d\n",array[finalIndexStart],array[finalIndexEnd], (array[finalIndexStart]+array[finalIndexEnd]));   
     }
}
