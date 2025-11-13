import java.util.Scanner;
import java.util.NoSuchElementException;
/**
 * Write a description of class MyTextContainer here.
 *
 * @author Beshoy Metias
 * @version 11/11/2025
 */
public class MyTextContainer
{
    private static final int INITIAL_CAPACITY = 1;
    private String[] v;
    private int vSize;
    public MyTextContainer()
    {
    v = new String[INITIAL_CAPACITY];
    vSize = 0;
    }
    
    public void add(String aLine)
    {
        if(aLine==null)
        {
            return;
        }
        if(vSize >= v.length)
        {
            String[] newV = new String[v.length*2];
            for(int i = 0; i<v.length; i++)
            {
                newV[i] = v[i];
            }
            v = newV;
        }
        v[vSize]= aLine;
        vSize++;
    }
    public boolean isEmpty(){
        return vSize <= 0;
    }
    public String removeFirst()
    {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        String tmpString = v[0];
        for(int i=0; i<vSize-1; i++ )
        {
            v[i]=v[i+1];
        }
        v[vSize-1]=null;
        vSize--;
        return tmpString;
    }
}