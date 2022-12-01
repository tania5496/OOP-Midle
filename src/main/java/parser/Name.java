package parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class Name {
    private Document doc;
    private String name;
    public void findName() throws IOException {
        name = doc.title();
    }
    Name(Document doc){
        this.doc = doc;
    }
}
