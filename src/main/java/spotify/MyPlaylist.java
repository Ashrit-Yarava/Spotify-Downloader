package spotify;

import com.github.kiulian.downloader.YoutubeException;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistsItemsRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyPlaylist {

    ArrayList<MyTrack> playlist;

    public MyPlaylist(String playlistUrl, String OAuthToken, String youtubeApi) throws ParseException, SpotifyWebApiException, IOException {
        String playlistId = playlistUrl.substring(playlistUrl.lastIndexOf("/") + 1);
        SpotifyApi spotify = new SpotifyApi.Builder().setAccessToken(OAuthToken).build();
        GetPlaylistsItemsRequest request = spotify.getPlaylistsItems(playlistId).build();

        Paging<PlaylistTrack> playlistTrackPaging = request.execute();
        PlaylistTrack[] track = playlistTrackPaging.getItems();

        playlist = new ArrayList<MyTrack>();
        for(PlaylistTrack t: track) {
            playlist.add(new MyTrack(t, youtubeApi));
        }
    }

    public void download() throws IOException, YoutubeException, InvalidDataException, NotSupportedException, UnsupportedTagException {
        for(MyTrack track: playlist) {
            track.downloadSong();
        }
    }

    public String toString() {
        return playlist.toString();
    }

}
