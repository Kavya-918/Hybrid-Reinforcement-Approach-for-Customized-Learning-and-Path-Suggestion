/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webrecomendation;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author parents gift
 */
public class Extract {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        //3&9 not tok-pages
//for(int i=1;i<=100;i++)1-6-7-8
        {int i=1;
        //String url="f:\\webpages\\msaccess.html";
        String url="f:\\webpages\\";
        String[] files=new File(url).list();
        for(String pagename:files)
        {
        Page page = new Page(url+pagename,pagename);
        
        if(page.extractPage())
        {
       page.listExtractor();
     
        }
       
        }
        String kw="ms";
         System.out.println(kw);
            String str="";
        for(String c:Page.tree.get(kw))
        { str=str+"--";
        System.out.print(str+c+"\n");
        }
        TreeMap<Integer,ArrayList<String>> rTree=new TreeMap<Integer,ArrayList<String>>();
        for(String pagename:files)
        {
            int index=pagename.indexOf(kw);
        if(!rTree.containsKey(index))
            rTree.put(index,new ArrayList<String>());
        if(index>=0)
            rTree.get(index).add(pagename);
        }
        for(ArrayList<String> al:rTree.descendingMap().values())
        {
        for(String rp:al)
            System.out.println(rp);
        }
        
//Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
//String title=doc.title();
//System.out.println("title:"+title);
//Elements links = doc.select("a[href]"); // a with href
//for(int i=0;i<links.size();i++)
//{
//System.out.println(links.get(i).text());
//}
//Elements pngs = doc.select("img[src$=.png]");
//  // img with src ending .png
//
//Element masthead = doc.select("div.masthead").first();
//  // div with class=masthead
//
//Elements resultLinks = doc.select("h3.r > a"); // direct a after h3
    }
    }

}

class Page {
    private String pageurl;
    private String pagename;
    private Document doc;
    private String adjectives[] = {"tallest", "largest", "smallest", "gratest", "biggest", "best","most","top", "best of","most"};
    private String delimeters[] = {" ", ",", "-", ":", ";", "-","|"};
    private String concept_delimeters[] = {",", "-", ":", ";", "-","|"," in "," at "};
    private String time_delimeters[] = {" at "," @ "};
    private String location_delimeters[] = {" in "," on "};
  
    static TreeMap<String,TreeSet<String>> tree=new TreeMap<String,TreeSet<String>>();
  
    
    private String ranks[] = adjectives;
    private String title;
    private String strK;
    private String rank;
    private String concept;
    private String time;
    private String location;
    private int k;
  public ArrayList list;
    
    public Page(String pageurl,String pagename) throws IOException {
        this.pageurl=pageurl;this.pagename=pagename;
        File input = new File(this.getPageurl());
        doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
           }
       
    public boolean extractPage() {
        boolean yes = false;
        int word_index=0;
        setTitle(getDoc().title().toLowerCase());
        //setTitle(getTitle().replaceAll(",", " "));
        //System.out.println("title:" + title);
        String words[] = getTitle().split(" ");
        String title2=getTitle(); 
        String str="--";
         for (int i = 0; i < words.length; i++) {
//            str=str+"--";
//        System.out.print(str+words[i]+"\n");
//        
        if(tree.get(words[i])==null)
            tree.put(words[i],new TreeSet());
        if(i+1<words.length)
        tree.get(words[i]).add(words[i+1]);
        
        
        }
         
         
//////        for(String kw:tree.keySet())
//////        {  System.out.println(kw);
//////            str=str+"--";
//////        for(String c:tree.get(kw))
//////        { str=str+"--";
//////        System.out.print(str+c+"\n");
//////        }
//////        }
        for(int i=0;i<=word_index;i++)
        {
        title2=title2.replace(words[i],"");
        }
       ///////System.out.println(title2.trim());
       
       int index_c=title2.length();
       for(int i=0;i<concept_delimeters.length;i++)
       {
       int index=title2.indexOf(concept_delimeters[i]);
       if(index>=0)
       {
           index_c=index;
           break;
       }
       }
       this.concept=title2.substring(0,index_c);

       int index_t=-1;
       for(int i=0;i<time_delimeters.length;i++)
       {
       int index=title2.indexOf(time_delimeters[i]);
       if(index>=0)
       {
           index_t=index+time_delimeters[i].length();
           break;
       }
       }
       if(index_t>=0)
       {   int index=title2.indexOf(" ",index_t+1);
           this.time=title2.substring(index_t,index>=0?index:title2.length());  
       }
           int index_l=-1;
       for(int i=0;i<location_delimeters.length;i++)
       {
       int index=title2.indexOf(location_delimeters[i]);
       if(index>=0)
       {
           index_l=index+location_delimeters[i].length();
           break;
       }
       }
       if(index_l>=0)
       {
           int index=title2.indexOf(" ",index_l+1);
           this.location=title2.substring(index_l,index>=0?index:title2.length());
       }
        return yes;
    }
    
    public boolean listExtractor() throws SQLException
    {
        TreeMap<String,ArrayList<String>> tagpath=new TreeMap<String,ArrayList<String>>();
        
    list=new ArrayList();
    //Candidate Picker
    Elements alltags=doc.getAllElements();
    for(int i=0;i<alltags.size();i++)
    {   String tag="";
                  if(alltags.get(i).attr("class")==null)
                    tag="<"+alltags.get(i).tagName()+">".trim().toLowerCase();
                  else
                    tag="<"+alltags.get(i).tagName()+" "+alltags.get(i).attr("class")+">".trim().toLowerCase();
                    
        String text=alltags.get(i).getElementsByTag(alltags.get(i).tagName()).html().trim().toLowerCase();
        if(tagpath.containsKey(tag))
            tagpath.get(tag).add(text);
        else
        {
            tagpath.put(tag,new ArrayList<String>());
            tagpath.get(tag).add(text);
        }
        
    //    System.out.println(tag);
    //    System.out.println(text);
        
    }
    String listitemtag="";
    ArrayList<String> temptext=new ArrayList<String>();
    
    for(String key:tagpath.keySet())
    {
        ArrayList<String> all=tagpath.get(key);
    if(all.size()==getK())
    {   
        System.out.println(key+"->"+all.size());
        temptext.add(key);
      
    }
    }
   
   float rankmatrix=0;
   String listitem="";
   String[] itemtag=new String[temptext.size()];
   int i=0;
    for(String key:temptext)
    {
     //System.out.println(key+"->>>"+tagpath.get(key));
     if(rankmatrix<tagpath.get(key).size())
     {
         rankmatrix=tagpath.get(key).size();
         listitem=key;
     }
    }

System.out.println("List Item :"+listitem);
System.out.println("---------------------------");
int ii=1;



TOPKPAGE tpage=new TOPKPAGE();
tpage.setPAGE_NAME(pagename);
tpage.setPAGE_URL("Top-K Pages\\"+pagename);
tpage.setPAGE_TITLE(title);
tpage.setTITLE_K(k+"");
tpage.setTITLE_CONCEPT(concept);
tpage.setTITLE_LOCATION(this.location);
tpage.setTITLE_RANK(rank);
tpage.setTITLE_TIME(time);

for(String str:tagpath.get(listitem))
{
System.out.println("=======================================");
System.out.println(ii+" of "+tagpath.get(listitem).size());
System.out.println(str);
tpage.setLISTITEM(str);
            try {
                tpage.addEntry();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
ii++;
System.out.println("=======================================");

}
    
    return true;
    }
public void titleClassifier()
{
String t_title=getTitle();
    
    
}
    /**
     * @return the pageurl
     */
    public String getPageurl() {
        return pageurl;
    }

    /**
     * @param pageurl the pageurl to set
     */
    public void setPageurl(String pageurl) {
        this.pageurl = pageurl;
    }

    /**
     * @return the doc
     */
    public Document getDoc() {
        return doc;
    }

    /**
     * @param doc the doc to set
     */
    public void setDoc(Document doc) {
        this.doc = doc;
    }

    /**
     * @return the adjectives
     */
    public String[] getAdjectives() {
        return adjectives;
    }

    /**
     * @param adjectives the adjectives to set
     */
    public void setAdjectives(String[] adjectives) {
        this.setAdjectives(adjectives);
    }

    /**
     * @return the ranks
     */
    public String[] getRanks() {
        return ranks;
    }

    /**
     * @param ranks the ranks to set
     */
    public void setRanks(String[] ranks) {
        this.setRanks(ranks);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param adjectives the adjectives to set
     */
   
    /**
     * @return the delimeters
     */
    public String[] getDelimeters() {
        return delimeters;
    }

    /**
     * @param delimeters the delimeters to set
     */
    public void setDelimeters(String[] delimeters) {
        this.delimeters = delimeters;
    }

    /**
     * @param ranks the ranks to set
     */
  

    /**
     * @return the strK
     */
    public String getStrK() {
        return strK;
    }

    /**
     * @param strK the strK to set
     */
    public void setStrK(String strK) {
        this.strK = strK;
    }

    /**
     * @return the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * @return the concept
     */
    public String getConcept() {
        return concept;
    }

    /**
     * @param concept the concept to set
     */
    public void setConcept(String concept) {
        this.concept = concept;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the k
     */
    public int getK() {
        return k;
    }

    /**
     * @param k the k to set
     */
    public void setK(int k) {
        this.k = k;
    }

}
