/**
   Fondamenti di Informatica - Gruppo 2
   Prova di programmazione del 16-07-2018
   
   Pila estesa di dati di tipo generico
   
   @typeparam T   il tipo generico memorizzato nella pila
   @see EmptyStackException
   @see S
*/
public class SE<T extends Comparable> extends S<T>
{
   
   /**
       @return una pila che contiene gli stessi elementi di questa pila, nella stessa sequenza
   */
   public Stack clone()
   {
      // generazione di una nuova pila vuota
      Stack s = new S();
      
      // accesso a tutti gli elementi di questa pila      
      Object[] v = toArray();
      
      // inserimento degli elementi nella nuova pila
      for (int i = v.length - 1; i >= 0; i--)// attenzione! dall'ultimo al primo
         s.push(v[i]);       
         
      return s;            
    }
    
   /**
       @return una pila che contiene gli stessi elementi di questa pila, ma in sequenza inversa
   */
   public Stack reverse()
   {
      // generazione di una nuova pila vuota
      Stack s = new S();  
      
      // accesso a tutti gli elementi di questa pila            
      Object[] v = toArray();
      
      // inserimento degli elementi nella nuova pila
      for (int i = 0; i < v.length; i++) // attenzione! dal primo all'ultimo
         s.push(v[i]);     
         
      return s;            
    }
    
    /**
       ispeziona tutti gli elementi di questa pila
       @return array contenenti gli elementi di questa pila in sequenza LIFO
    */
    public Object[] toArray()
    {
       // generazione di un arrai
       Object[] v = new Object[size()];
       
       // accesso con estrazione agli elementi della pila
       int i = 0;
       while (!isEmpty())
          v[i++] = pop();
          
       // re-inserimento degli elementi della pila
       for (i = v.length -1; i >= 0; i--) // attenzione alla sequenza!
          push((T)v[i]);                  // attenzione al forzamento!
          
       return v;   
    }
    
    public Object[] toSortedArray()
    {
       // ispezione di tutti gli elementi di questa pila
       Object[] v = toArray();

       // ordinamento
       sort(v);
       
       return v;
    } 
    
   // ordinamento per fusione O(nlogn)
   private void sort(Object[] a)
   {
      if (a.length < 2)
         return;
      
      int mid = a.length / 2;
      Object[] left = new Object[mid];   
      Object[] right = new Object[a.length - mid];
      System.arraycopy(a, 0, left, 0, left.length);
      System.arraycopy(a, mid, right, 0, right.length);
      
      sort(left);
      sort(right);
      
      merge(a, left, right);                  
   }
   
   // ordinamento per fusione
   private void merge(Object[] a, Object[] b, Object[] c)
   {
      int ia = 0, ib = 0, ic = 0;
      
      while (ib < b.length && ic < c.length)
         if (((Comparable)b[ib]).compareTo(c[ic]) < 0) // attenzione al forzamento!
            a[ia++] = b[ib++];
         else
            a[ia++] = c[ic++];   
      
      while (ib < b.length)
         a[ia++] = b[ib++];      
      
      while (ic < c.length)
         a[ia++] = c[ic++];             
   }           
}
