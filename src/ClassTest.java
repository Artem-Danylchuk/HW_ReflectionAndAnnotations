import java.io.FileNotFoundException;
import java.io.PrintWriter;

@SaveTo(fileName = "/Users/artemdanylchuk/test/test.txt")
public class ClassTest {
    String text = "It is work!-!";

    @Saver()
    public void saveText(String savePath,String saveText){
        try(PrintWriter pw = new PrintWriter(savePath)){
            pw.println(saveText);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
