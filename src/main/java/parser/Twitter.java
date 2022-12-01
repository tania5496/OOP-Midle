package parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class Twitter {
    private Document doc;
    private String twitter;
    public void findTwitter() throws IOException {
        ArrayList<Element> twitterLink = doc.select("a[href^=https://twitter.com/]");
        twitter = twitterLink.get(0).attr("abs:href");
    }
    Twitter(Document doc){
        this.doc = doc;
    }
}
