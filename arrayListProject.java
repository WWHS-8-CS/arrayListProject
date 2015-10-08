    private Object[] list; 
    private int logicalSize; 
     
    public MyArrayList() 
    { 
       list = new Object[10]; 
       logicalSize=0;     
    } 
     
    public int size() 
    { 
       return logicalSize; 
    } 
     
    public String toString() 
    { 
       String s = ""; 
        
       for (int i = 0; i < logicalSize; i++) 
          s = s + list[i] +"   "; 
        
       return s;    
    }
   
    public Object get(int i) 
    { 
       return list[i]; 
    } 
     
    public Object set( int index, Object value) 
    { 
       Object temp = list[index]; 
       list[index] = value; 
       return temp;       
    } 
     
    public boolean add(Object object) 
    { 
       if (logicalSize == list.length) 
       { 
          expandList(); 
       } 
        
      list[logicalSize] = object; 
      logicalSize = logicalSize + 1; 
       
       return true; 
    }   
     
    public void add(int index, Object object) throws Exception 
    { 
       if (index > logicalSize) 
          throw new Exception("Index out of bounds"); 
        
       if(logicalSize == list.length) 
          expandList(); 
        
       for (int i = logicalSize; i > index; i--) 
          list[i] = list[i-1]; 
        
       list[index] = object;       
       logicalSize++; 
    } 
     
    private void expandList() 
    { 
       Object [] temp = new Object[list.length+10]; 
        
       for (int i = 0; i < logicalSize; i++) 
          temp [i] = list[i]; 
        
       list = temp; 
    }
 
    public Object remove(int index) 
    { 	
	int counter = 0; 
	int currentSize = logicalSize;
	if(index >= currentSize || currentSize = 0 || index < 0)
		throw new Exception("Index out of bounds"); 
	int newSize = curentSize - 1;
	 
        Object[] temp = new Object[newSize];
	for(int i = 0; i < list.size(); i++)
	{
		if(i != index) 
		{
			temp[counter] = list.get(i);
			counter++;
		}
	}
	logicalSize = newSize;
	list = temp;	
    }   
}
