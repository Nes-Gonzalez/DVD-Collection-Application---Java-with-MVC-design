
import java.io.FileNotFoundException;
public class Controller {
    private Collection collection=new Collection();
    public void UCAddDVD(String title,String category,String runningTime,String year,String price)
    {
        collection.AddDVD(title,category,runningTime,year,price);
    }
    public void UCEditDVD(String title)
    {
        collection.EditDVD(title);
    }
    public void UCFindDVD(String title)
    {
        collection.FindDVD(title);
    }
    public void UCListDVD(String title)
    {
        collection.ListDVD(title);
    }
    public void UCRemoveDVD(String title)
    {
        collection.RemoveDVD(title);
    }
    public void UCSortYear()
    {
        collection.SortYear();
    }
    public void UCSortTitle()
    {
        collection.SortTitle();
    }
    public void UCSave()throws FileNotFoundException
    {
        collection.Save();
    }
    public void UCLoad() throws FileNotFoundException
    {
        collection.Load();
    }

}
