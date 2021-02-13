import com.github.kiulian.downloader.YoutubeException;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import org.apache.hc.core5.http.ParseException;
import spotify.MyPlaylist;
import spotify.MyTrack;

import java.io.IOException;

public class Main {

    public static void run(String youtubeApi, String spotifyApi, String spotifyUrl) {
        MyPlaylist playlist;
        try {
            playlist = new MyPlaylist(spotifyUrl, spotifyApi, youtubeApi);
            playlist.download();
        } catch (ParseException | IOException | YoutubeException | SpotifyWebApiException | UnsupportedTagException | InvalidDataException | NotSupportedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String youtubeAPI = "AIzaSyD8ZjB2h7Cv1JxdhwCeotEQ5rMOHIxoYHk";
        String spotifyAPI = "BQDA9c7PAtO4Yv0O0Hcr7UYEy3T5E6bvG1TaQ2bqJTjIGDS0YezWAfALD-SZfN0wGRuvQk_ItXBwy3uYo9uueSKZGPqrHaiSDiiFGPqV7iSs7w1istCwWGhknHIajPzx4zvw92OH_lXNpBHbH3fZzKK39NycGa0_6DBEKmDHrcK5nqU";
        String playlistURL = "https://open.spotify.com/playlist/0DNjk37VkGOcjqZNqzQF1o";
        run(youtubeAPI, spotifyAPI, playlistURL);
    }

}
