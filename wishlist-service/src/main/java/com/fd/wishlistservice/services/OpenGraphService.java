package com.fd.wishlistservice.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;
@Service
public class OpenGraphService {

    public Map<String, String> getOpenGraphData(String url) throws IOException {
        Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Referer", "https://www.google.com").timeout(60000).get() ;// zaman aşımını ayarla.get();

        Map<String, String> ogData = new HashMap<>();
        ogData.put("title", doc.select("meta[property=og:title]").attr("content"));
        ogData.put("description", doc.select("meta[property=og:description]").attr("content"));
        ogData.put("image", doc.select("meta[property=og:image]").attr("content"));

        return ogData;

    }
}
