import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class base {
    public static Properties obj;
    public base() throws IOException {
        FileInputStream file=new FileInputStream("/Users/thanisha/IdeaProjects/DummyApi/src/main/java/config.properties");
        obj=new Properties();
        obj.load(file);
    }
}