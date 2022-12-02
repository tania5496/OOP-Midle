package parser;
import lombok.Getter;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class Twitter {
    private final Document doc;
    @Getter
    private String twitter;
    @SneakyThrows
    public void findTwitter(){
        ArrayList<Element> twitterLink = doc.select("a[href^=https://twitter.com/]");
        twitter = twitterLink.get(0).attr("abs:href");
    }
    public Twitter(Document doc){
        this.doc = doc;
    }
}
