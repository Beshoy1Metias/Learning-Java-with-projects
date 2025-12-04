import java.util.Scanner;
public class StudentSortedRecords implements Container
{
	String DELIMITER=":";
    private Student[] students;
    private int size=0;
    private static final int INITIAL_CAPACITY = 10;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		StudentSortedRecords archive = new StudentSortedRecords();
		while(in.hasNextLine())
		{
			String line = in.nextLine();
			if(line.startsWith("*"))
			{
				continue;
			}
			archive.add(line, ":");
		}
		archive.print();
		System.out.print("\n \n"+ archive.getName(56816));
		Student stud = archive.removeMin();
		System.out.print("\nremoved student: "+ stud+ "\n");
		archive.print();
	}
	public void print()
	{
		for(int i=0; i<size; i++)
		{
			System.out.print(students[i]+"\n");
		}
	}
	public StudentSortedRecords()
	{
		students = new Student[INITIAL_CAPACITY];
	}
	public void add(String name, int rollno)
	{
		if(size<=students.length)
		{
			Student[] f = new Student[students.length*2];
			System.arraycopy(students, 0, f, 0, size);
			students = f;
			
		}
		Student hi = new Student(name, rollno);
		students[size]= hi;
		size++;
	}
	public void add(String s, String delimiters)
	{

		Scanner scanner = new Scanner(s);
		scanner.useDelimiter(delimiters);
		String name = scanner.next();
		int rollno = scanner.nextInt();
		add(name, rollno);
		insertionSort(students);
		scanner.close();
		//Student s = new Student(name, rollno);
	}
	public void insertionSort(Student[] d) //2 5 4 7 1
	{
		for(int i=0; i<=size; i++)
		{
			int min = findMinPos(d, i);
			if(i==min)
			{
				continue;
			}
			else{
				swap(d, i, min);
			}
		}
	}
	public void swap(Student[] d, int i, int j)
	{
		Student tmp = d[i];
		d[i]=d[j];
		d[j] = tmp;
	}
	public int findMinPos(Student[] d, int from)
	{
		int minIndex =from;
		for(int i = from; i<size; i++)
		{
			if(d[i].compareTo(d[minIndex])<0)
			{
				minIndex=i;
			}
			
		}
		return minIndex;
	}
	public String binarySearch(int rollNo, int left, int right)
	{
		int mid = (left+right)/2;
		int midroll = students[mid].rollno();
		int leftroll = students[left].rollno();
		int rightroll = students[right].rollno();
		if(midroll == rollNo)
		{
			return students[mid].name();
		}
		else if(midroll<rollNo)
		{
			return binarySearch(rollNo, mid+1, right);
		}
		else{return binarySearch(rollNo, left, mid-1);}
	}
	public String getName(int rollNo)
	{
		return binarySearch(rollNo, 0, size-1);
		/*for(int i=0; i<size; i++)
		{
			if(students[i].rollno() == rollNo)
			{
				return students[i].name();
			}
		}
		return "Not found";*/
	}
	
	@Override
	public boolean isEmpty()
	{
		return students.length == 0 || students==null;
	}
	
	public Student removeMin()
	{
		Student tmp = students[0];
		students[0]=null;
		for(int i=1; i<size; i++)
		{
			students[i-1]=students[i];
		}
		size--;	
		return tmp;
	}
	
	@Override
	public void makeEmpty()
	{
		for(int i =0; i<size; i++)
		{
			students[i]=null;
		}
		size =0;
	}
	
	@Override
	public int size()
	{
		return size;
	}
}