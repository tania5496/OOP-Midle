package com.middle.demo.parser;
import java.util.ArrayList;

import lombok.Getter;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Icon{
    private final Document doc;
    @Getter
    private String icon;
    @SneakyThrows
    public void findIcon(){
        ArrayList<Element> icons = doc.select("head > link[rel=shortcut icon]");
        icon = icons.get(0).attr("abs:href");
    }
    public Icon(Document doc){
        this.doc = doc;
    }
}
