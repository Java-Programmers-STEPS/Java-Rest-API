package jsonexmpl;
	import java.io.*;
	import java.net.HttpURLConnection;
	import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
public class Rest2 {

	
	public static void main(String args[])throws IOException{
	try {	
		String url = "https://jsonplaceholder.typicode.com/todos";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
    JSONArray jsonArray = new JSONArray(response.toString());
    for (int i = 0; i < jsonArray.length(); i++) {
    	
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        System.out.println("UserID: " + jsonObject.getInt("userId"));
        System.out.println("ID: " + jsonObject.getInt("id"));

        System.out.println("Title: " + jsonObject.getString("title"));
        System.out.println("Completed: " + jsonObject.getBoolean("completed"));
        System.out.println("-------------------------------");
    }
} catch (Exception e) {
    e.printStackTrace();
}
}
}

