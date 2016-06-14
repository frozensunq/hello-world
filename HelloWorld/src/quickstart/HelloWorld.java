package quickstart;

/**
 * Created by sunqi on 5/17/16.
 */

import java.io.IOException;
import java.util.*;
import java.net.*;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("This version has been committed to Github!");
        String strOrig = "Hello, world! Hello, IDEA!";
        searchLastString(strOrig, "He");
        replaceString(strOrig,"ha");
        System.out.println(strOrig);
        reverseString(strOrig);
        if(searchString(strOrig, "rooo") < 0){
           System.out.println("\'or\' NOT found in strOrig.");
        } else {
            System.out.println("\'or\' found in strOrig.");
        }
        splitString("www-runoob-com", "-");
        splitString("www.runoob.com", "o*");
        splitString("www    run  oob com", " {2,}"); // using space(s) as delimiter.

        hashMapTest();

        getIP("www.runoob.com");

        //scanPort("localhost");
        getRemoteFileSize();

        scaleExchagne();
    }

    public static void scaleExchagne(){
        //十进制转为其他进制
        System.out.println(Integer.toBinaryString(112));
        System.out.println(Integer.toHexString(112));
        System.out.println(Integer.toOctalString(112));

        //其他进制转为十进制
        System.out.println(Integer.parseInt("111101", 2)); //binary
        System.out.println(Integer.parseInt("27", 8));
        System.out.println(Integer.parseInt("A2", 16));

    }

    public  static void getRemoteFileSize(){
        int size = 0;
        try {
            URL url = new URL("http://www.w3cschool.cc/wp-content/themes/w3cschool.cc/assets/img/newlogo.png");
            URLConnection conn = url.openConnection();
            size = conn.getContentLength();
            conn.getInputStream().close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch(IOException e){}
        if(size > 0)
            System.out.println("Got the file, size is " + size + "bytes");
        else
            System.out.println("Failed to get the file");


    }

    public static void scanPort(String hostname){
        Socket skt;
        System.out.println(hostname);
        for(int i = 0; i < 1024; i++){
            try{
                System.out.println("查看 " + i);
                skt = new Socket(hostname, i);
                System.out.println("端口 " + i + " 已经被占用");
            }
            catch (UnknownHostException e){
                System.out.println("Socket Exception occurred " + e);
                break;
            }
            catch (IOException e){
            }
        }
    }

    public static void getIP(String site){
        InetAddress address = null ;
        try {
            address = InetAddress.getByName(site);
        } catch (UnknownHostException e){ e.printStackTrace(); }
        System.out.println(address.getHostName() + " is : " + address.getHostAddress());

        try {
            InetAddress localAddr = InetAddress.getLocalHost();
            System.out.println("local host name is: " + localAddr.getHostName());
            System.out.println("local host address is: " + localAddr.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public static void hashMapTest(){
        HashMap<String, String> hMap = new HashMap<String, String>();
        hMap.put("2", "2nd");
        hMap.put("1", "1st");
        hMap.put("5", "5th");
        hMap.put("3", "3rd");
        Collection c = hMap.values();
        Iterator itr = c.iterator();
        while(itr.hasNext()){
            System.out.println("itr is like this: " + itr.toString());
            System.out.println(itr.next());
        }
    }
    public static void splitString(String str, String delimiter){
        String [] tmp1;
        tmp1 = str.split(delimiter);
        for(int i = 0; i < tmp1.length; i++){
            System.out.println(tmp1[i]);
        }
        System.out.println("Java for each test:");
        for(String x : tmp1){
            System.out.println(x);
        }
        System.out.println("---------------");
    }

    public static void searchLastString(String strOrig, String candidate){
        int lastIndex = strOrig.lastIndexOf(candidate);
        System.out.println("strOrig = " + strOrig + "\ncandidate = " + candidate + "\nlastIndex = " + lastIndex);
    }
    public static void replaceString(String strOrig, String tmp){
        System.out.println(strOrig.replace("H", "W"));
        System.out.println(strOrig.replaceFirst("He", "\\\\"));
        System.out.println(strOrig.replaceAll("(l+)o,", "mmm$0xxxx$1yyyy"));
        String strOrig2 = "\\Rose is Jack's girlfriend.";
        System.out.println("strOrig2 = " + strOrig2);
        System.out.println(strOrig2.replaceAll("\\\\", "\\$"));
        System.out.println(strOrig2.replaceAll("(Rose)(.*)(Jack)(.*)(girl)", "$3$2$1$4boy"));


    }
    public static void reverseString(String strOrig){
        StringBuffer reverse = new StringBuffer(strOrig);
        reverse.reverse().toString();
        System.out.println("Before reverse: " + strOrig);
        System.out.println("After reverse: " + reverse);
    }
    public static int searchString(String strOrig, String substr){
        return strOrig.indexOf(substr);
    }
}
