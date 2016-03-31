/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package magicsquare;

/**
 *
 * @author s4262971
 */
public class MagicSquare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        // sum = (M(M+1))/1
        
        int squareSize = 200;
        long MagicNumber = ((squareSize*((squareSize*squareSize)+1))/2);
        System.out.println("Magic Square Number: "+MagicNumber);
        
        //long magicNumber = (squareSize*(squareSize+1)/2);
        //long buffer[][] = new long[squareSize][squareSize];
        //fillArray(buffer, 0);
        //printCLISquare(buffer);

        printCLISquare(getMagicSquare(squareSize));
    }
    public static long[][] fillArray(long[][] buf, long number)
    {
        int vert=0;
        int horz=0;
        for(vert=0; vert<buf.length; vert++)
        {
            for(horz=0; horz<buf[vert].length; horz++)
            {
                buf[horz][vert]=number;
            }
        }
        return buf;
    }
    public static void printCLISquare(long[][] magicArray)
    {
        int vert=0;
        int horz=0;
        for(vert=0; vert<magicArray.length; vert++)
        {
            for(horz=0; horz<magicArray[vert].length; horz++)
            {
                System.out.print("["+magicArray[vert][horz]+"]");
                //System.out.print('['+"0"+']');
            }
            System.out.println();
        }
    }
    public static long [][] getMagicSquare(int squareSize)  //odd magic squares ??
    {
        long buffer[][] = new long[squareSize][squareSize];
        
        int count=0;
        int runningPointVert=0;
        int runningPointHorz=((squareSize/2));
        
        for(long i=1; (squareSize*squareSize)>=i; i++,runningPointVert--,runningPointHorz++ ) //iterate for size of square then  check validity
        {
            //apply correction
            if(runningPointVert<0)
            {
                runningPointVert=(squareSize-1);
            }
            if(runningPointHorz>(squareSize-1))
            {
                runningPointHorz=0;
            }
            
            if(buffer[runningPointVert][runningPointHorz]!=0)       //is already filled. then go down one and continue
            {
                buffer[runningPointVert+1][runningPointHorz]=i;
                runningPointVert=runningPointVert+1;
            }
            else
            {
                buffer[runningPointVert][runningPointHorz]=i;
            }
            //printCLISquare(buffer);
            //System.out.println();
        }
        if(isContainsZero(buffer)==false)
        {
            return buffer;
        }
        else
        {
            System.out.println("ERROR ZEROS FOUND IN SQUARE");
            System.out.println("SQUARE FILLED INCORRECTLY");
            return null;
        }
    }
    public static boolean isContainsZero(long array[][])
    {
        for(int vert=0; vert<array.length; vert++)
        {
            for(int horz=0; horz<array[vert].length; horz++)
            {
                if(array[vert][horz]==0)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isValidSquare(long [][]magicSquare)
    {
        //to do
        return true;
    }
}
