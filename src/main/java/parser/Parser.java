package parser;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Parser {
    @SneakyThrows
    public Document parse(String domain) {
        String url = "https://" + domain +"/";
        Document doc = Jsoup.connect(url).get();
        return doc;
    }
}
