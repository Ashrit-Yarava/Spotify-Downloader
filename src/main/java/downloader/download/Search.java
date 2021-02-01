package downloader.download;

import org.jsoup.Jsoup;

import java.io.IOException;

import com.alibaba.fastjson.JSONObject;

public class Search {

    public static String getID(String keyword, String apiKey) throws IOException {
        keyword = keyword.replace(" ", "+");
        String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&order=rating&q=" + keyword + "&key=" + apiKey;
        String doc = Jsoup.connect(url).ignoreContentType(true).execute().body();
        
        doc = doc.substring(doc.indexOf("\"videoId\": ") + 12);
        doc = doc.substring(0, doc.indexOf("\""));

        return doc;
    }

}
