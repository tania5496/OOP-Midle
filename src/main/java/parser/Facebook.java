package parser;
import java.util.ArrayList;

import lombok.Getter;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Facebook{
    private final Document doc;
    @Getter
    private String facebook;
    @SneakyThrows
    public void findFacebook(){
        ArrayList<Element> facebookLink = doc.select("a[href^=https://www.facebook.com/]");
        facebook = facebookLink.get(0).attr("abs:href");
    }
    public Facebook(Document doc){
        this.doc = doc;
    }
}
