package downloader.spotify;

import java.io.IOException;

import com.github.kiulian.downloader.YoutubeException;

import downloader.download.*;

public class Track {

    private String name, artist, url, thumbUrl;

    public Track(String name, String artist, String url, String thumbUrl) {
        this.name = name;
        this.artist = artist;
        this.url = url;
        this.thumbUrl = thumbUrl;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getUrl() {
        return url;
    }

    public String thumbUrl() {
        return thumbUrl;
    }

    public void downloadVideo(String youtubeAPIKey) {
        String youtubeId = "";
        try {
            youtubeId = Search.getID(this.name + " " + this.artist, youtubeAPIKey);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            Download.download(youtubeId);
        } catch (YoutubeException | IOException e) {
            e.printStackTrace();
        }
    }

    

}
