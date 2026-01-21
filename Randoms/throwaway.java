
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   /*
	   int count=0;
	   int len = findAll(key).length;
	   Object[] tmp = new Object[vSize];
	   int j=0;
	   for(int i=0; i<vSize;i++)
	   {
		   if(((Entry)v[i]).getKey().equals(key))
		   {
			   
			   int m = i;
			   while(j<=len && vSize>=0)
			   {
				   tmp[j]=((Entry)v[m]).getValue();
				   int ss = m+len;
				   if(ss>vSize){ss=vSize;}
				   v[m]=v[ss];
				   m++;
				   j++;
				   vSize--;
			   }
			   break;
		   }
	   }
	   if(j<vSize)
	   {
		   Object[] temporary= new Object[j];
		   System.arraycopy(tmp, 0, temporary, 0, temporary.length);
		   tmp=temporary;
	   }
	   return tmp;*/