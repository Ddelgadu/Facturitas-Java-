package facturitas;

import java.sql.*;
import java.util.ArrayList;

public class baseDeDatos{

	Connection c = null;
	Statement stmt = null;
	String name = null;
	
	public baseDeDatos(String name){
		
		this.name = name;
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:"+name+".db");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	
		System.out.println("Opened database successfully");
	}
	
	public void createTable(String tableName, ArrayList<String> datos){
		     
   	 	//Crear String columnas
   	 	datos.toString();
   	 	
		//Connectar a db	 	
   	   try {
           Class.forName("org.sqlite.JDBC");
           c = DriverManager.getConnection("jdbc:sqlite:"+this.name+".db");
           System.out.println("Opened database successfully");

           stmt = c.createStatement();
           String sql = "CREATE TABLE IF NOT EXISTS " + tableName+" " + "(" +datos.toString().substring(1, datos.toString().length()-1)+")";
           stmt.executeUpdate(sql);
           stmt.close();
           c.close();
        } catch ( Exception e ) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
           System.exit(0);
        }
	      System.out.println("Table "+tableName+" created successfully");
	}

	public void insert(String tableName){
		try {
			Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:"+this.name+".db");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         System.out.println("Opened database "+ this.name+" successfully");
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM "+tableName+";" );
		     String[] s = dCol.getColumnNameArray(rs);
		     String d="(";
		     for(int i=0; i<s.length;i++){
		    	 d=d+s[i]+",";		    			 
		     }
		     d=d.substring(0,d.length()-1)+")";
	         String sql = "INSERT INTO "+tableName+" "+ d + 
	                        " VALUES (1, 'Paul', 32, 56.89);"; 
	         System.out.println(sql);
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.commit();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      
		 System.out.println("Records created successfully");
	  }

	public void select(String tableName){

		try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:"+this.name+".db");
		  c.setAutoCommit(false); 
		  System.out.println("Opened database successfully");		  	
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM "+tableName+";" );
	      String[] s = dCol.getColumnNameArray(rs);
	      String[] t = dCol.getColumnTypeArray(rs);
	      
	      while ( rs.next() ) {
	    	 for(int i=0; i<s.length;i++){
	    		 if (t[i].toUpperCase().equals("TEXT")){
	    	          String a = rs.getString(s[i]);
	    	       System.out.println( s[i]+":" + a );
	    		 }else if(t[i].toUpperCase().equals("INT")){
	    		 	int a= rs.getInt(s[i]);
	    		 	System.out.println( s[i]+":"+ a );
	    		 }else if(t[i].toUpperCase().equals("REAL")){
		    		 	float a= rs.getFloat(s[i]);
		    		 	System.out.println( s[i]+":"+ a );
		    	 }
	    	 	}
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	   } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	   }
	   System.out.println("Operation done successfully");
	  }
	
}


	




