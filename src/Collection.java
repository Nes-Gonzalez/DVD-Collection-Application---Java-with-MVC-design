
import java.util.Vector;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Collections;

public class Collection {
    private int MaxDVDs=10;
    private int NumberOfDVDs=0;
    private DVD holder;
    private String word;
    private Vector<DVD> DVDlist=new Vector<DVD>();
    private Scanner keyboard = new Scanner(System.in);
    public void AddDVD(String title,String category, String runningTime, String year, String price)
    {
        System.out.println("Add DVD");
        if(DVDlist.size()>=MaxDVDs)
	{
		System.out.println("***DVD list is full, Add DVD failed please remove DVDs to make space*** ");
	}
        else
        {
            System.out.println(title+" "+category+" "+runningTime+" "+year+" "+price);
            holder=new DVD(title,category,runningTime,year,price);
            DVDlist.add(DVDlist.size(), holder);
            NumberOfDVDs++;
        }
    }
    public void RemoveDVD(String title)
    {
        System.out.println("Remove DVD: "+ title);
        boolean found = false;
        for(int i =0;i<NumberOfDVDs;i++){
            holder=DVDlist.elementAt(i);
            if(holder.getTitle().equals(title))
            {
                DVDlist.remove(i);
                System.out.println("***DVD Removed***");
                NumberOfDVDs--;
                found=true;
                break;
            }
        }
        if(!found)
            System.out.println("***DVD not found***");

    }
    public void EditDVD(String title)
    {
        System.out.println("Edit: "+title);
        boolean found=false;
        for(int i =0;i<NumberOfDVDs;i++){
            holder=DVDlist.elementAt(i);
            if(holder.getTitle().equals(title))
            {
                System.out.println(holder.getTitle()+" "+holder.getCategory()+" "+holder.getRunningTime()+" "+holder.getYear()+" "+holder.getPrice());
                System.out.println("DVD found, fill out new infromation...");
                System.out.println("Enter new Title: ");
                word=keyboard.nextLine();
                holder.setTitle(word);
                System.out.println("Enter new Category");
                word=keyboard.nextLine();
                holder.setCategory(word);
                System.out.println("Enter new Running Time");
                word=keyboard.nextLine();
                holder.setRunningTime(word);
                System.out.println("Enter new Year");
                word=keyboard.nextLine();
                holder.setYear(word);
                System.out.println("Enter new Price");
                word=keyboard.nextLine();
                holder.setPrice(word);
                found = true;
                DVDlist.add(i,holder);
                break;
            }
        }
        if(!found)
                System.out.println("***DVD not found***");
    }
    public void FindDVD(String title)
    {
        System.out.println("Find DVD");
        boolean found=false;
        for(int i =0;i<NumberOfDVDs;i++){
            holder=DVDlist.elementAt(i);
            if(holder.getTitle().equals(title))
            {
                System.out.println(holder.getTitle()+" "+holder.getCategory()+" "+holder.getRunningTime()+" "+holder.getYear()+" "+holder.getPrice());
                System.out.println("DVD found");
                break;
            }
        }
        if(!found)
            System.out.println("***DVD not found***");
    }
    public void ListDVD(String category)
    {
        System.out.println("List by Category");
        for(int i =0;i<NumberOfDVDs;i++)
        {
            holder=DVDlist.elementAt(i);
            if(holder.getCategory().equals(category))
                System.out.println(holder.getTitle()+" "+holder.getCategory()+" "+holder.getRunningTime()+" "+holder.getYear()+" "+holder.getPrice());
        }
    }
    public void SortTitle()
    {
        System.out.println("Sort by Title");
        Vector<DVD> Clist=new Vector<DVD>();
        Clist=DVDlist;
        Collections.sort(Clist,DVD.TitleComparator);
        for(int i =0;i<NumberOfDVDs;i++)
        {
            holder=Clist.elementAt(i);
            System.out.println(holder.getTitle()+" "+holder.getCategory()+" "+holder.getRunningTime()+" "+holder.getYear()+" "+holder.getPrice());
        }
    }
    public void SortYear()
    {
        System.out.println("Sort by Year");
        Vector<DVD> Clist=new Vector<DVD>();
        Clist=DVDlist;
        Collections.sort(Clist);
        for(int i =0;i<NumberOfDVDs;i++)
        {
            holder=Clist.elementAt(i);
            System.out.println(holder.getTitle()+" "+holder.getCategory()+" "+holder.getRunningTime()+" "+holder.getYear()+" "+holder.getPrice());
        }
    }
    public void Save() throws FileNotFoundException
    {
        System.out.println("Saving...");
        PrintWriter fileOutput=new PrintWriter(new FileOutputStream("Catalog.txt"));
        for(int i=0;i<NumberOfDVDs;i++)
        {
            holder=DVDlist.elementAt(i);
            fileOutput.println(holder.getTitle()+","+holder.getCategory()+","+holder.getRunningTime()+","+holder.getYear()+","+holder.getPrice());
        }
        fileOutput.close();

    }
    public void Load() throws FileNotFoundException
    {
        Scanner fileInput=new Scanner(new FileInputStream("Catalog.txt"));
        while(fileInput.hasNextLine())
        {
            word=fileInput.nextLine();
            String[] wordsList=word.split(",",-1);
            DVD holder = new DVD(wordsList[0],wordsList[1],wordsList[2],wordsList[3],wordsList[4]);
            System.out.println(wordsList[0]+" "+wordsList[1]+" "+wordsList[2]+" "+wordsList[3]+" "+wordsList[4]);
            DVDlist.add(holder);
            NumberOfDVDs++;

        }
        System.out.println("Loaded");
        fileInput.close();
    }
}
