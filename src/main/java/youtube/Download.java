package youtube;


import com.github.kiulian.downloader.YoutubeDownloader;
import com.github.kiulian.downloader.YoutubeException;
import com.github.kiulian.downloader.model.YoutubeVideo;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;

public class Download {

    private static String getSearchResult(String keyword, String apiKey) throws IOException {
        keyword = keyword.replace(" ", "+");
        String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&order=rating&q=" + keyword + "&key=" + apiKey;
        String doc = Jsoup.connect(url).ignoreContentType(true).execute().body();

        doc = doc.substring(doc.indexOf("\"videoId\": ") + 12);
        doc = doc.substring(0, doc.indexOf("\""));

        return doc;
    }

    public static File downloadVideo(String song, String outputPath, String apiKey) throws YoutubeException, IOException {
        YoutubeDownloader downloader = new YoutubeDownloader();
        YoutubeVideo video = downloader.getVideo(getSearchResult(song, apiKey));

        return video.download(video.formats().get(0), new File("."), outputPath, true);
    }

}
