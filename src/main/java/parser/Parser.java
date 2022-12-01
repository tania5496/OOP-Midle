package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Parser {
    private String url=null;
    public Document parse() throws IOException {
        Document doc = Jsoup.connect(url).get();
        return doc;
    }
    Parser(String domain){
        this.url = "https://" + domain +"/";
    }
}