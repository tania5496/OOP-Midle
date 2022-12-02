package com.middle.demo.parser;
import lombok.Getter;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class Name {
    private Document doc;
    @Getter
    private String name;
    @SneakyThrows
    public void findName(){
        name = doc.title();
    }
    public Name(Document doc){
        this.doc = doc;
    }
}
