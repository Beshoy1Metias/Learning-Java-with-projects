/**
  * Implements a simply-linked list by using generics
  *
  * @param E the parametric data type of the elements of this linked list
  *
  * @author A. Luchetta
  * version 06/12/2023
  */
public class LinkedListGenerics<E> implements Container
{
   // private part
   private ListNode head, tail;  // references to the first and last node
   
   // inner class
   private class ListNode
   {
      // private part
      private E element;
      private ListNode next;
      
      // public part
      
      /*
         Constructs a new listNode with the specified element and next node
         - param anElement the specified element
         - param aNode the specified next node
      */
      public ListNode(E anElement, ListNode aNode)
      {
         setElement(anElement);
         setNext(aNode);
      }
      
      /*
         Constructs an new empty ListNode
      */
      public ListNode()
      {
         this(null, null);
      }
      
      /*
         Returns the element in this ListNode
         -return the element contained in this ListNode
      */      
      public E getElement(){ return element; }
      
      /*
         Returns the reference to the next node of this ListNode
         - return the reference to the next node of this ListNode
      */      
      public ListNode getNext(){ return next; }
      
      /*
         Returns the reference to the next node of this ListNode
         -return the reference to the next node of this ListNode
      */      
      public void setElement(E e){ element = e;} 
      
      /*
         Returns the reference to the next node of this ListNode
         -return the reference to the next node of this ListNode
      */      
      public void setNext(ListNode n){ next = n;}             
   }
   
   // public part
   
   /**
      Constructs an empty linked list
   */
   public LinkedListGenerics()
   {
      makeEmpty();          // we can use makeEmpty as it initializes a new 
   }                        // linked list
   
   /**
      Adds the specified element as the first element in this linked list
      @param element the specified element
   */
   public void addFirst(E element)
   {
      // insert the element into the node head
      head.setElement(element);
      
      // create new head node and link to previous head
      head = new ListNode(null, head);
   }
   
   /**
      Adds the specified element as the last element in this linked list
      @param element the specified element
   */
   public void addLast(E element)
   {
      // create a new node to contain the element
      ListNode tmp = new ListNode(element, null);
      
      // link with the tail node
      tail.setNext(tmp);
      
      // move tail to the newly created node
      tail = tail.getNext();      
   }   
   
   /**
      Returns the first element of this linked list if not empty
      @return the first element of this linked list if not empty
      @throws EmptyLinkedListException if the linkedlist is empty
   */
   public E getFirst()
   {
      // preconditions
      if (isEmpty())
      {
         throw new EmptyLinkedListException();
      }
      
      return head.getNext().getElement();
   }
   
   /**
      Returns the first element of this linked list if not empty
      @return the first element of this linked list if not empty
      @throws EmptyLinkedListException if the linkedlist is empty
   */
   public E getLast()
   {
      // preconditions
      if (isEmpty())
      {
         throw new EmptyLinkedListException();
      }
      
      return tail.getElement();
   } 
   
   /**
      Checks if this container is empty
      @return true if this container is empty    
   */
   public boolean isEmpty()
   {
      return head == tail;
   }
   
   /**
      Makes this container empty  
   */
   public void makeEmpty()
   {
      head = tail = new ListNode();
   }   
   
   /**
      Removes and returns the first element in the linked list if not empty
      @return the element removed from the the linked list if not empty
      @throws EmptyLinkedListException if the linkedlist is empty
   */
   public E removeFirst()
   {
      // temporary storage of the element to remove
      E e = getFirst();   // throws EmtyLinkedListException if the linked
                               // list is empty
                                        
      // advance head
      head = head.getNext();
      
      // remove the element
      head.setElement(null);
      
      return e;
   }
   
   /**
      Removes and returns the last element in the linked list if not empty
      @return the element removed from the the linked list if not empty
      @throws EmptyLinkedListException if the linkedlist is empty
   */
   public E removeLast()
   {
      // temporary storage of the element to remove
      E e = getLast();    // throws EmtyLinkedListException if the linked
                               // list is empty
                                        
      // loop to search for the node in front of the tail node
      ListNode tmp = head;
      while (head != tail)
      {
         tmp = tmp.getNext();
      }
      
      // move tail
      tail = tmp;
      
      // remove the link with tail
      tail.setNext(null);
             
      return e;
   }           
}
