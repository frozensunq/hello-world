package quickstart;

/**
 * Created by sunqi on 6/14/16.
 */
import java.io.File;
import java.io.IOException;

public class FileUtilTest {
    public static void main(String[] args) throws IOException {
        FileUtil.listDirectory(new File("/Users/sunqi/Documents/study/piano"));
        System.out.println("-------------------------");
        FileUtil.filterType(new File("/Users/sunqi/Documents/study/piano"), "Zip");
    }
}
