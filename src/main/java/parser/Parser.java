package parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Parser {
    private String url=null;
    public Document parse() throws IOException {
        System.out.println(url);
        Document doc = Jsoup.connect(url).get();
        return doc;
    }
    public Parser(String domain){
        this.url = "https://" + domain +"/";
    }
}
