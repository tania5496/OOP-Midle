package parser;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Icon{
    private Document doc;
    private String icon;
    public void findIcon() throws IOException {
        ArrayList<Element> icons = doc.select("head > link[rel=shortcut icon]");
        icon = icons.get(0).attr("abs:href");
        System.out.println(icon);
    }
    Icon(Document doc){
        this.doc = doc;
    }
}
