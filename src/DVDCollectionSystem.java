
import java.util.Scanner;
import java.io.FileNotFoundException;
public class DVDCollectionSystem {
    public static void main(String[] args) throws FileNotFoundException
    {
        String title;
        String category;
        String runningTime;
        String year;
        String price;
        int input=10;

        View view =new View();
        Controller control = new Controller();
        control.UCLoad();

        while(input!=0)
        {
            System.out.println(" ");
            view.showMenu();
            System.out.println(" ");
            Scanner keyboard = new Scanner(System.in);
            input=Integer.parseInt(keyboard.nextLine());
            if(input==1)
            {
                System.out.println("Adding DVD");
                System.out.print("Enter Title: ");
                title=keyboard.nextLine();
                System.out.print("Enter Category: ");
                category=keyboard.nextLine();
                System.out.print("Enter RunningTime: ");
                runningTime=keyboard.next();
                runningTime+=" Mins.";
                System.out.print("Enter Year: ");
                year = keyboard.next();
                System.out.print("Enter Price: ");
                price = keyboard.next();
                control.UCAddDVD(title,category,runningTime,year,price);
            }
            else if(input==2)
		{
			System.out.println("Remove DVD ");
			System.out.print("Enter Title: ");
			title=keyboard.nextLine();
			control.UCRemoveDVD(title);
		}
		else if(input==3)
		{
			System.out.println("Edit DVD ");
			System.out.print("Enter Title: ");
			title=keyboard.nextLine();
			control.UCEditDVD(title);
		}
		else if(input==4)
		{
			System.out.println("List DVD \n Enter Category: ");
			category=keyboard.nextLine();
			control.UCListDVD(category);
		}
		else if(input==5)
		{
			System.out.println("Find DVD ");
			System.out.print("Enter Title: ");
			title=keyboard.nextLine();
			control.UCFindDVD(title);
		}
		else if(input==6)
		{
			System.out.println("Sort DVDs by Year ");
			control.UCSortYear();
		}
		else if(input==7)
		{
			System.out.println("Sort DVDs by Title ");
			control.UCSortTitle();
		}
		else if(input==0)
		{
			control.UCSave();
			System.exit(0);
		}
		else
			System.out.println("not a valid entry,please retry ");
        }

    }

}
