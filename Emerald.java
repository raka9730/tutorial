package eme;

import java.io.*;
import java.net.*;
import java.sql.*;

public class Emerald{
    
    Connection conn =null;
    PreparedStatement ps=null;
    ResultSet rs = null;
    
    public static void main(String[] args) throws IOException, MalformedURLException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, InterruptedException {
        
        Emerald ob = new Emerald();
        ob.callingDB();
    }
       
 void callingDB() throws MalformedURLException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, InterruptedException{
           
        conn=MySQLConnect.connect();
        
         for(int k=1;k<5;k++)
        {
        
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
        String url1="https://www.emeraldinsight.com/toc/arj/31/"+k+"";
        URL url = new URL(url1);
        URLConnection con = url.openConnection();
        con.setRequestProperty("User-Agent","Mozilla/5.0");
        InputStream is =con.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
    
        
        String line="";
        String red="";
        String final_link="";
        int pos=0;
        int count=0;
        String title="";
        int position=0;
        
        while ((line = br.readLine()) != null) 
        {
            String ar[] = line.split("/doi/pdfplus/");
            
            for(int kj=0;kj<ar.length;kj++){
                
            if(ar[kj].contains("PDF ") && ar[kj].contains("\">") && ar[kj].contains("10."))
                {
//                   System.out.println(ar[kj]);
                
                  final_link=ar[kj].substring(ar[kj].indexOf("10.")+3,ar[kj].indexOf("\">"));
                  
                    System.out.println(final_link);
                    
                    System.out.println(sample);
      

////***************************************************************************************************    
//                  
                try{
            
            String sql="select count(*) from emerald";      
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) 
            {
                count=rs.getInt(1);
            }System.out.println("cou="+count);
                            
          sql="insert into emerald values(?,?,?)";
            
            ps=conn.prepareStatement(sql);
            ps.setInt(1,count++);
            
            ps.setString(2,final_link);
            ps.setInt(3,position);
            ps.executeUpdate();
         }catch(SQLException e)
         {
                  
           System.out.println(e);
       }
                }}}
            
                }  
conn.close();         
}}
        
        
      





    
        
   
                                             
   



