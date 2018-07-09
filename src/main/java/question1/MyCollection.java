package question1;

/**
 * Please implement Dynamic Array Interface 
 * @author 
 *
 */
public class MyCollection implements DynamicArray{
// Uncomment commented section
	
	/**
	 * You can declare local/global variables as per your requirement
	 */
	@SuppressWarnings("unused")
	private int[] numArray;
	int counter=0;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		numArray = new int[arraySize];
	}

	public int search(int searchingNum) {
		for(int i=0;i<numArray.length;i++)
		{
			if(numArray[i]==searchingNum)
				return i;
		}
		
			return -1;
	
		
	}

	public boolean add(int numberToAdd) {
		// TODO Auto-generated method stub
	int available=	search(numberToAdd);
	if(available!=-1)
		return false;
	 int count=getCount();
	if(count==numArray.length)
	doubleCapacity();
	if(available==-1 && (count< numArray.length))
		numArray[count]=numberToAdd;
		counter++;
	return true;
	}

	public void doubleCapacity() {
		// TODO Auto-generated method stub
		int newa[]=new int[numArray.length*2];
		for(int i=0;i<counter;i++)
			newa[i]=numArray[i];
		numArray=newa;
		
	}


	public boolean remove(int numberToRemove) {
		int available=search(numberToRemove);
		if(available!=-1) {
			for(int i=available;i<counter;i++){
				numArray[i]=numArray[i+1];
			}
			counter--;
			return true;
		}
		return false;
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		
		return counter;
	}


	public int[] rotate(int n) {
		// TODO Auto-generated method stub
	int k=0;
		int arr[]= new int[n];
		for(int i=0;i<n;i++)
			arr[i]=numArray[i];
		for(int i=0;i<counter-n;i++)
			numArray[i]=numArray[i+n];
		for(int i=(counter)-n;i<counter;i++)
			numArray[i]=arr[k++];
		
		return numArray;
	}
	
	
	public String toString( ) {
		String s="{";
		if(counter!=0) 
		{
			for(int i=0;i<counter-1;i++)
			{
				s=s+numArray[i]+",";
			}
			s=s+numArray[counter-1]+"}";
		}
		if(counter==0) {
			return "{}";
		}
		return s;
	}
	
	
	
	
	
	
	
	
	
}
