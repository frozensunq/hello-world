package quickstart;

/**
 * Created by sunqi on 6/14/16.
 */
public class EncodeDemo {
    public static void main(String[] args) throws Exception {
        String s = "慕课ABC";
        byte[] bytes1 = s.getBytes();
        for(byte b : bytes1){
            //把字节转成int以16进制展示,并且去掉前导零
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        System.out.println();
        System.out.println("Using s.getBytes(GBK):");
        byte[] bytes2 = s.getBytes("GBK");
        for(byte b : bytes2){
            //把字节转成int以16进制展示,并且去掉前导零
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        System.out.println();
        System.out.println("Using s.getBytes(utf-8):");
        byte[] bytes3 = s.getBytes("utf-8");
        for(byte b : bytes3){
            //把字节转成int以16进制展示,并且去掉前导零
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        //java是双子符字节
        System.out.println();
        System.out.println("Using s.getBytes(utf-16be):");
        byte[] bytes4 = s.getBytes("utf-16be");
        for(byte b : bytes4){
            //把字节转成int以16进制展示,并且去掉前导零
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        System.out.println();
        System.out.println("Bytes -> String");
        String str4 = new String(bytes4); // Using default encodeing, which is utf-8
        System.out.println(str4); // 乱码
        str4 = new String(bytes4, "utf-16be");
        System.out.println(str4);// 正常
        String str3 = new String(bytes3);
        System.out.println(str3);// 正常
    }
}
