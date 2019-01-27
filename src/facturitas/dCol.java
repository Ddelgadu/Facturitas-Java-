package facturitas;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class dCol {
	String name;
	String type;
	String isNull="NOT NULL";
	String isKey="";
	
	public dCol(String name, String type, boolean isKey, boolean isNull){
		this.name=name;
		this.type= type;
		if(isNull==true){
			this.isNull="";
		}
		if(isKey==true){
			this.isKey="PRIMARY KEY";
		}
	}
	
	public String toString(){
		String colString = this.name+" "+this.type;
		if(this.isKey!=""){
			colString = colString+" "+this.isKey;
		}
		if(this.isNull=="NOT NULL"){
			colString = colString+" "+this.isNull;
		}
				
		return colString;
	}
	
	public static String toStrings(dCol[] datos){
		String col = "(";
   	 	for(int i=0;i<datos.length;i++){
			 col = col + datos[i].toString();
			 if (i!=datos.length-1){
				 col= col + ", ";
			 }else{
				 col = col + ")";
			 }
        }
		return col;
	}
	
	public static String[] getColumnNameArray(ResultSet rs) {
		  String sArr[] = null;
		  try {
		    ResultSetMetaData rm = rs.getMetaData();
		    String sArray[] = new String[rm.getColumnCount()];
		    for (int ctr = 1; ctr <= sArray.length; ctr++) {
		      String s = rm.getColumnName(ctr);
		      sArray[ctr - 1] = s;
		    }
		    return sArray;
		  } catch (Exception e) {
		    System.out.println(e);
		    return sArr;
		  }
		}
	
	public static String[] getColumnTypeArray(ResultSet rs) {
		  String sArr[] = null;
		  try {
		    ResultSetMetaData rm = rs.getMetaData();
		    String sArray[] = new String[rm.getColumnCount()];
		    for (int ctr = 1; ctr <= sArray.length; ctr++) {
		      String s = rm.getColumnTypeName(ctr);
		      sArray[ctr - 1] = s;
		    }
		    return sArray;
		  } catch (Exception e) {
		    System.out.println(e);
		    return sArr;
		  }
		}
}
