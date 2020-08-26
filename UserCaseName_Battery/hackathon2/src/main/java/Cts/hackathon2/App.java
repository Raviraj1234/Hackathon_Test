package Cts.hackathon2;

/**
 * Hello world!
 *
 */
import java.io.*;
import org.json.simple.*;

public class App 
{
    public static void main( String[] args )throws IOException
    {
    	
    	BufferedReader br=new BufferedReader(new FileReader("Battery.txt"));
    	
    	String line;
    	
    	String foreground="";
    	
    	float batterydrain=0.0f;

    	while((line=br.readLine())!=null) {
    		if(line.contains("Foreground")) { 
    			String data1[]=line.split("\\s+");
    			foreground=data1[3]+" "+data1[4]+" "+data1[5]+" "+data1[6]+" "+data1[7]+" "+data1[8];
        		
    		}
    		
    		if(line.contains("Uid u0a202")) {
    			String data2[]=line.split("\\s+");
    			
    			batterydrain=Float.parseFloat(data2[3]);
    				
    		}
    		
    	}
    	
    	float battery_percent=Float.parseFloat(String.format("%.3f",(float)batterydrain/1000));
    	System.out.println(batterydrain);
    	System.out.println(foreground);
    	 JSONObject finalJson =new JSONObject();
    	 JSONArray finalarray=new JSONArray();
    	   finalJson.put("Foreground_time", foreground);
    	   finalJson.put("Battery_percentage", battery_percent);
    	   finalJson.put("Battery_drain", batterydrain);
    	   finalarray.add(finalJson);
    	   System.out.println(finalJson);
    	   FileWriter file=new FileWriter("Output.json");
       		file.write(finalarray.toJSONString());
       		file.close();
       		br.close();
    	
    }
  

}

