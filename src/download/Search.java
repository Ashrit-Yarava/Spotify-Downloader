package download;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Search {

    public static void main(String[] args) throws IOException {
        String keyword = "how to make apple pie filling";
        keyword = keyword.replace(" ", "+");
        String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&order=rating&q=" + keyword + "&key=YOUR_YOUTUBE_API_KEY";
        Document doc = Jsoup.connect(url).timeout(10 * 1000).get();
        String getJson = doc.text();
        JSONObject jsonObject = (JSONObject) new JSONTokener(getJson).nextValue();
        System.out.println(jsonObject.getString("videoId"));
    }

}
