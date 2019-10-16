package 第14章类型信息.proxy.myownproxy.MyTest;

import java.net.*;
import java.io.*;
public class URLConnDemo
{
    public static void main(String [] args)
    {
        try
        {
            URL url = new URL("http://www.baidu.com");
            System.out.println(url.getFile());
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if(urlConnection instanceof HttpURLConnection)
            {
                connection = (HttpURLConnection) urlConnection;
            }
            else
            {
                System.out.println("请输入 URL 地址");
                return;
            }
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String urlString = "";
            String current;
            while((current = in.readLine()) != null)
            {
                urlString += current;
            }
            System.out.println(urlString);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
