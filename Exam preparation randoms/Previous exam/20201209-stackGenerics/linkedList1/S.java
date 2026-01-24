/**
  * Fondamenti di Informatica - Gruppo 2
  * Prova di programmazione del 16-07-2018
  * 
  * Struttura dati che realizza il tipo dati astratto pila di elementi generici
  * Realizzazione con Lista Concatenata
  * 
  * @param T il tipo generico memorizzato nella pila
  * @see Stack
  * @see EmptyStackException
*/
public class S<T> implements Stack<T>
{
   // parte privata
   private LinkedList<T> l; 
   
   /**
      inizializza una pila vuota
   */
   public S()
   {
      makeEmpty();
   }
   
   /**
      @return true se il contenitore e' vuoto, false altrimenti
   */
   public boolean isEmpty()
   {
      return l.isEmpty();
   }

   /**
     rende il contenitore vuoto
   */
   public void makeEmpty()
   {
       l = new LinkedList<T>();   
   }
  
   /**
      @return  numero di elementi nel contenitore
   */
   public int size()
   {
      return l.size();
   }
  
   /**
       inserisce l'elemento specificato in cima alla pila
       @param o l'elemento specificato
       @throws IllegalArgumentException se l'elemento specificato vale null
    */
    public void push(T o) // O(1)
    {
       if (o == null)
          throw new IllegalArgumentException();
         
       l.addFirst(o);    
    }
   
    /**
       ispeziona l'elemento in cima alla pila
       @return l'elemento in cima alla pila
       @throws EmptyStackException se la pila e' vuota
    */
    public T top() throws EmptyStackException // O(1)
    {
       if (isEmpty())
          throw new EmptyStackException();
         
       return l.getFirst();
    }

    /**
       rimuove l'elemento in cima della pila
       @return l'elemento rimosso
       @throws EmptyStackException se la pila e' vuota
    */
    public T pop()throws EmptyStackException // O(1)
    {
       T x = top();
       
       l.removeFirst();     
      
       return x;
    }
    
    /**
       provides the textual description of this stack consisting of a string
       in which the stack elements are in LIFO sequence separated by a space
       character
       @return textual description
    */
    public String toString()
    {
       // return string
       String r = "";
       
       // temporary stack
       Stack s = new S();
              
       // extracting the elements from the stack
       while (!isEmpty())
       {
          r = r + " " + top();    // concatenating with the return string
          s.push(pop());          // saving in temporary stack
       } // here the stack is empty
       
       // reinserting the elements in the stack in the LIFO sequence
       while (!s.isEmpty())
          push((T)s.pop());
          
       return r;   
    } 
}
