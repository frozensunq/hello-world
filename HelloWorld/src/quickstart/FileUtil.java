package quickstart;

/**
 * Created by sunqi on 6/14/16.
 */

import java.io.File;
import java.io.IOException;

public class FileUtil {
    public static void listDirectory(File dir) throws IOException {
        if(!dir.exists())
            throw new IllegalArgumentException("目录" + dir + "不存在");
        if(!dir.isDirectory())
            throw new IllegalArgumentException("不是目录");
        /*
        String[] str1 = dir.list();
        for(String str : str1){
            System.out.println(str);
        }
        */

        File[] files = dir.listFiles();
        for(File f : files) {
            if(f.isDirectory())
                listDirectory(f);
            else
                System.out.println(f.getCanonicalPath());
        }
    }

    public static void filterType(File dir, String type) throws IOException {
        if(!dir.exists())
            throw new IllegalArgumentException("目录" + dir + "不存在");
        if(!dir.isDirectory())
            throw new IllegalArgumentException("不是目录");
        String typeTmp = "."+type.toLowerCase();
        File[] files = dir.listFiles();
        boolean flag = false;
        for(File f : files) {
            if(f.isDirectory())
                filterType(f, type);
            else {
                if(f.toString().indexOf(typeTmp) > 0) {
                    flag = true;
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
        if(!flag)
            System.out.println("No "+ type + " files in the " + dir.toString());



    }
}
