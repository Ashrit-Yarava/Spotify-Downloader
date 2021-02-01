package downloader.spotify;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistsItemsRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class Playlist {

    public static String getId(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }

    public static void run(String oauthToken, String playlistURL)
            throws ParseException, SpotifyWebApiException, IOException {
        final String playlistId = getId(playlistURL);

        SpotifyApi spotifyApi = new SpotifyApi.Builder().setAccessToken(oauthToken).build();
        GetPlaylistsItemsRequest request = spotifyApi.getPlaylistsItems(playlistId).build();

        Paging<PlaylistTrack> playlistTrackPaging = request.execute();
        PlaylistTrack[] track = playlistTrackPaging.getItems();

        // Get Track Name: track[0].getTrack().getName();
        // Get Track Artist: ((Track) track[0].getTrack()).getArtists()[0].getName();
        // Get Track URI: track[0].getTrack().getURI();

        System.out.println();
    }

    public static void main( String[] args) {
        String playlist = "https://open.spotify.com/playlist/0DNjk37VkGOcjqZNqzQF1o";
        String oauthToken = "BQCKQKzssve-6CWt9JdTt4DIvIpCdf7-s7LmnKdLg8qgFnLkeuCIQLyM5fUyt8m9Uvhli-j0OWhwwGJSBBsTnaU-455LQwnn4SfNqZIpqNDcrjfFrKDt885aAJ2iG9nQ2534OB3r6yw8C-nDY5EW0_GtqLcjoPmBkXwuF9Eg0inRWh8";
        try {
            run(oauthToken, playlist);
        } catch (ParseException | SpotifyWebApiException | IOException e) {
            e.printStackTrace();
        }
    }
}
