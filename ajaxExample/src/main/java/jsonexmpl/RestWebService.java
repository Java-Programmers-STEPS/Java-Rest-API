package jsonexmpl;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
public class RestWebService {
public static void main(String args[])throws IOException{
	
String apiUrl="https://jsonplaceholder.typicode.com/posts/";
URL url=new URL(apiUrl);
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");
int responseCode = connection.getResponseCode();
if (responseCode==200) {
	BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	String inputLine;
	StringBuffer response=new StringBuffer();
	while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
	in.close();
	System.out.println(response.toString());
}else {
	System.out.println("Request failed with response code: " + responseCode);
}
	
	
}
}
