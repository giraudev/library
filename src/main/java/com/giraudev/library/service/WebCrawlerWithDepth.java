package com.giraudev.library.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class WebCrawlerWithDepth {

    private static final int MAX_DEPTH = 2;
    private HashSet<String> links;

    public WebCrawlerWithDepth() {
        links = new HashSet<>();
    }


    public void getPageLinks(String URL) {
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements elementosTag = doc.select("a[href]");

            System.out.println("Elementos com a tag a[href]:");

            for (Element el : elementosTag)
                System.out.println(el.text());
        } catch (IOException e) {
            System.err.println("For '" + URL + "': " + e.getMessage());

        }
    }

    public static void main(String[] args) {
        new WebCrawlerWithDepth().getPageLinks("https://kotlinlang.org/docs/books.html");
    //    new WebCrawlerWithDepth().getPageLinks("https://kotlinlang.org/docs/books.html", 0);

    }
}
