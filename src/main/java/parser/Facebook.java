
package org.example;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Facebook{
    private Document doc;
    private String facebook;
    public void findFacebook() throws IOException {
        ArrayList<Element> facebookLink = doc.select("a[href^=https://www.facebook.com/]");
        facebook = facebookLink.get(0).attr("abs:href");
    }
    Facebook(Document doc){
        this.doc = doc;
    }
}