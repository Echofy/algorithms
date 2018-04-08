package ans.cla;

import java.util.Scanner;

class Solution003 {

	// solution 1
    public static boolean Find(int target, int [][] array) 
    {
        for(int i = 0; i < array.length; i++)
            for(int j = 0; j < array[0].length; j++)
                if(array[i][j] == target)
                    return true;
        return false;
    } // end Find

    // solution 2
    public boolean Find2(int target, int [][] array)
    {
        int sCol = array.length-1;
        int sRow = 0;
         
        if(sCol == 0)
            return false;
         
        while(sCol > 0 && sRow < array[0].length-1)
        {
            if(array[sCol][sRow] == target)
                return true;
             
            if(array[sCol][sRow] > target)
            {
                sCol--;
                continue;
            }
 
            if(array[sCol][sRow] < target)
            {
                sRow++;
                continue;
            }
        } // end while
         
        if(array[sCol][sRow] == target)
                return true;
         
        return false;
         
    } // end Find2

    
    public static void main(String [] args)
    {
        int array [][] = new int[3][3];
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter an array in order: ");
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
                array[i][j] = sc.nextInt();
        }
        
        boolean result = Find(3, array);

        if(result)
            System.out.println("successly find!");
        else
            System.out.println("find failed!");

    } // end main
    
} // end class 