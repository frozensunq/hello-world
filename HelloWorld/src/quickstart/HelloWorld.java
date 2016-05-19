package quickstart;

/**
 * Created by sunqi on 5/17/16.
 */
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
