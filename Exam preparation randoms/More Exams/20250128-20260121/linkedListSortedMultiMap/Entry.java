/**
   Defines a key-value mapping.
   
   @author A. Luchetta
   @version 26 Dec. 2024
*/
public class Entry
{
   // instance variables
   private Object key;
   private Object value;
   
   /**
      Constructs a new mapping with the specified key and value.
      @param k the specified key of this mapping.
      @param v the specified value of this mapping.
   */
   public Entry(Object k, Object v)
   {
      setKey(k);
      setValue(v);
   }
   
   /**
      Returns the key of this mapping.
      @return the key of this mapping. 
   */
   public Object getKey() { return key; }
   
   /**
      Returns the value of this mapping.
      @return the value of this mapping.
   */
   public Object getValue() { return value; } 
   
   /**
      Sets the key of this mapping with the specified key.
      @param k the specified key.
   */
   public void setKey(Object k) { key = k; }
   
   /**
      Sets the value of this mapping with the specified value.
      @param v the specified value. 
   */
   public void setValue(Object v) { value = v; }   
}
