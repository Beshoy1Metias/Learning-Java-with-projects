/**
  * Fondamenti di Informatica - Gruppo 2
  * Prova di programmazione del 16-07-2018
  * 
  * Lista Concatenata
  *    
  * @param T il tipo generico dei dati memorizzati nella lista concatenata
  * @see Container
  * @see EmptyLinkedListException
  */
public class LinkedList<T> implements Container
{
   // parte privata
   private ListNode head;
   private int size;  

   private class ListNode    // classe interna ListNode
   {
      private T element;
      private ListNode next;
      
      public ListNode(T e, ListNode n)
      {
         setElement(e);
         setNext(n);
      }
      
      public ListNode()
      {
         this(null, null);
      }
      
      public T getElement() { return element; }
      public ListNode getNext() { return next; }
      public void setElement(T e) { element = e; }
      public void setNext(ListNode n) { next = n; }
   }   
      
   /**
      inizializza una lista concatenata vuota
   */
   public LinkedList()
   {
      makeEmpty();
   }
      
  /**
     @return true se il contenitore e' vuoto, false altrimenti
  */
   public boolean isEmpty()
   {
      return head.getNext() == null;
   }
      
  /**
     @return  numero di elementi nel contenitore
  */
   public int size()
   {
      return size;
   }

   /**
     rende il contenitore vuoto
  */   
   public void makeEmpty()
   {
      head = new ListNode(); 
      size = 0;  
   }

   /**
      inserisce l'elemento specificato al primo posto della lista concatenata
      @param e l'elemento specificato
      @throws IllegalArgumentException se l'elemento specificato vale null  
   */
   public void addFirst(T e) // O(1)
   {
      if (e == null)
         throw new IllegalArgumentException();
            
      head.setElement(e);
      head = new ListNode(null, head); 
      size++;  
   }
      
   /**
      ispeziona il primo elemento della lista concatenata, se la lista non e' vuota
      @return il primo elemento della lista concatenata
      @throws EmptyLinkedListException se la lista concatenata e' vuota
   */
   public T getFirst() throws EmptyLinkedListException// O(1)
   {
      if (isEmpty())
         throw new EmptyLinkedListException();
            
      return head.getNext().getElement();   
   } 
      
   /**
      rimuove il primo elemento della lista concatenata, se la lista non e' vuota
      @return l'elemento rimosso dalla lista concatenata
      @throws EmptyLinkedListException se la lista concatenata e' vuota
   */
   public T removeFirst() throws EmptyLinkedListException // O(1)
   {
      T x = getFirst();
         
      head = head.getNext();
      head.setElement(null);
      size--;
         
      return x;
   } 
}
