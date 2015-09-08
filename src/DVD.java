
import java.util.Comparator;
import java.lang.Comparable;
public class DVD implements Comparable<DVD>
{
    private String title;
    private String category;
    private String runningTime;
    private String year;
    private String price;



    public DVD(String t,String c,String r, String y, String p)
    {
        this.title=t;
        this.category=c;
        this.runningTime=r;
        this.year=y;
        this.price=p;
    }
    public void setTitle(String t)
    {
        this.title=t;
    }
    public String getTitle()
    {
        return title;
    }
    public void setCategory(String c)
    {
        this.category=c;
    }
    public String getCategory()
    {
        return category;
    }
    public void setRunningTime(String r)
    {
        this.runningTime=r;
    }
    public String getRunningTime()
    {
        return runningTime;
    }
    public void setYear(String y)
    {
        this.year=y;
    }
    public String getYear()
    {
        return year;
    }
    public void setPrice(String p)
    {
        this.price=p;
    }
    public String getPrice()
    {
        return price;
    }
    public int compareTo(DVD a)
    {
        return Integer.parseInt(this.getYear())-Integer.parseInt(a.getYear());
    }
    public static Comparator<DVD> TitleComparator=new Comparator<DVD>()
    {
        public int compare(DVD a,DVD b)
        {
            String aTitle=a.getTitle().toUpperCase();
            String bTitle=b.getTitle().toUpperCase();
            return aTitle.compareTo(bTitle);
        }
    };

}
