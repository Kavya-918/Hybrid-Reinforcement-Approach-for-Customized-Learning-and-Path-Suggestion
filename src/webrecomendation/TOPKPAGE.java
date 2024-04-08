
package webrecomendation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TOPKPAGE 
{

private int PAGEID;
private String PAGE_NAME;
private String PAGE_URL;
private String PAGE_TITLE;
private String TITLE_K;
private String TITLE_RANK;
private String TITLE_CONCEPT;
private String TITLE_TIME;
private String TITLE_LOCATION;
private String LISTITEM;
Connection con;
PreparedStatement ps;
public TOPKPAGE() throws SQLException
{

 con=new DataBase().getConnection();
 ps=con.prepareStatement("insert into TOPK_PAGES(PAGE_NAME,PAGE_URL,PAGE_TITLE,TITLE_K,TITLE_RANK,TITLE_CONCEPT,TITLE_TIME,TITLE_LOCATION,LISTITEM) values(?,?,?,?,?,?,?,?,?)");
}


    /**
     * @return the PAGEID
     */
    public int getPAGEID() {
        return PAGEID;
    }

    /**
     * @param PAGEID the PAGEID to set
     */
    public void setPAGEID(int PAGEID) {
        this.PAGEID = PAGEID;
    }

    /**
     * @return the PAGE_NAME
     */
    public String getPAGE_NAME() {
        return PAGE_NAME;
    }

    /**
     * @param PAGE_NAME the PAGE_NAME to set
     */
    public void setPAGE_NAME(String PAGE_NAME) {
        this.PAGE_NAME = PAGE_NAME;
    }

    /**
     * @return the PAGE_URL
     */
    public String getPAGE_URL() {
        return PAGE_URL;
    }

    /**
     * @param PAGE_URL the PAGE_URL to set
     */
    public void setPAGE_URL(String PAGE_URL) {
        this.PAGE_URL = PAGE_URL;
    }

    /**
     * @return the PAGE_TITLE
     */
    public String getPAGE_TITLE() {
        return PAGE_TITLE;
    }

    /**
     * @param PAGE_TITLE the PAGE_TITLE to set
     */
    public void setPAGE_TITLE(String PAGE_TITLE) {
        this.PAGE_TITLE = PAGE_TITLE;
    }

    /**
     * @return the TITLE_K
     */
    public String getTITLE_K() {
        return TITLE_K;
    }

    /**
     * @param TITLE_K the TITLE_K to set
     */
    public void setTITLE_K(String TITLE_K) {
        this.TITLE_K = TITLE_K;
    }

    /**
     * @return the TITLE_RANK
     */
    public String getTITLE_RANK() {
        return TITLE_RANK;
    }

    /**
     * @param TITLE_RANK the TITLE_RANK to set
     */
    public void setTITLE_RANK(String TITLE_RANK) {
        this.TITLE_RANK = TITLE_RANK;
    }

    /**
     * @return the TITLE_CONCEPT
     */
    public String getTITLE_CONCEPT() {
        return TITLE_CONCEPT;
    }

    /**
     * @param TITLE_CONCEPT the TITLE_CONCEPT to set
     */
    public void setTITLE_CONCEPT(String TITLE_CONCEPT) {
        this.TITLE_CONCEPT = TITLE_CONCEPT;
    }

    /**
     * @return the TITLE_TIME
     */
    public String getTITLE_TIME() {
        return TITLE_TIME;
    }

    /**
     * @param TITLE_TIME the TITLE_TIME to set
     */
    public void setTITLE_TIME(String TITLE_TIME) {
        this.TITLE_TIME = TITLE_TIME;
    }

    /**
     * @return the TITLE_LOCATION
     */
    public String getTITLE_LOCATION() {
        return TITLE_LOCATION;
    }

    /**
     * @param TITLE_LOCATION the TITLE_LOCATION to set
     */
    public void setTITLE_LOCATION(String TITLE_LOCATION) {
        this.TITLE_LOCATION = TITLE_LOCATION;
    }

    /**
     * @return the LISTITEM
     */
    public String getLISTITEM() {
        return LISTITEM;
    }

    /**
     * @param LISTITEM the LISTITEM to set
     */
    public void setLISTITEM(String LISTITEM) {
        this.LISTITEM = LISTITEM;
    }
    
    public  void addEntry()throws Exception
    {boolean done=false;
    ps.setString(1,this.getPAGE_NAME());
    ps.setString(2,this.getPAGE_URL());
    ps.setString(3,this.getPAGE_TITLE());
    ps.setString(4,this.getTITLE_K());
    ps.setString(5,this.getTITLE_RANK());
    ps.setString(6,this.getTITLE_CONCEPT());
    ps.setString(7,this.getTITLE_TIME());
    ps.setString(8,this.getTITLE_LOCATION());
    ps.setString(9,this.getLISTITEM());
    try{if(ps.executeUpdate()>0)
      done=true;
  }catch(Exception ex){ex.printStackTrace();}

   }
    
    
}
