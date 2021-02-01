package downloader.spotify;

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

    public void downloadAudio() {
        
    }

}
