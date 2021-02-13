package spotify;

import com.github.kiulian.downloader.YoutubeException;
import com.mpatric.mp3agic.*;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;
import com.wrapper.spotify.model_objects.specification.Track;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import youtube.Download;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MyTrack {
    private final String name;
    private final String artistName;
    private final String apiKey;
    private final String albumName;
    private final String id;

    public MyTrack(PlaylistTrack playlist, String apiKey) {
        this.name = playlist.getTrack().getName();
        this.artistName = ((Track) playlist.getTrack()).getArtists()[0].getName();
        this.albumName = ((Track) playlist.getTrack()).getAlbum().getName();
        this.apiKey = apiKey;
        this.id = playlist.getTrack().getId();
    }

    public void downloadSong() throws IOException, YoutubeException, InvalidDataException, NotSupportedException, UnsupportedTagException {

        if((new File(this.artistName + " - " + this.name + ".mp3")).exists())
            return;

        String query = this.toString();
        File video = Download.downloadVideo(query, query, apiKey);

        File outputMp3 = new File("temp.mp3");
        convert(video, outputMp3);
        video.delete();
        File song = new File("temp.mp3");
        fixMetaData(song);
        outputMp3.delete();
    }

    public static void convert(File mp4, File mp3) throws IOException {
        FFmpeg ffmpeg;
        FFprobe ffprobe;

        if(System.getProperty("os.name").contains("Windows")) {
            ffmpeg = new FFmpeg("C:\\ffmpeg\\bin\\ffmpeg.exe");
            ffprobe = new FFprobe("C:\\ffmpeg\\bin\\ffprobe.exe");
        } else {
            ffmpeg = new FFmpeg("~/.ffmpeg/bin/ffmpeg");
            ffprobe = new FFprobe("~/.ffmpeg/bin/ffprobe");
        }

        FFmpegProbeResult format = ffprobe.probe(mp4.getAbsolutePath());

        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(format)
                .overrideOutputFiles(true)
                .addOutput(mp3.getAbsolutePath())
                .done();
        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
        executor.createJob(builder).run();
    }

    public void fixMetaData(File mp3) throws InvalidDataException, IOException, UnsupportedTagException, NotSupportedException {
        Mp3File song = new Mp3File(mp3);
        if(song.hasId3v2Tag()) {
            ID3v2 tag = song.getId3v2Tag();
            tag.setTitle(this.name);
            tag.setArtist(this.artistName);
            tag.setAlbum(this.albumName);
            tag.setAlbumImage(MyTrack.getThumbnail(this.id), this.albumName);
        }
        song.save( this.artistName + " - " + this.name + ".mp3");
    }

    private static byte[] getThumbnail(String trackId) throws IOException {
        Document doc = Jsoup.connect("https://open.spotify.com/oembed?url=spotify:track:" + trackId).ignoreContentType(true).get();
        String text = doc.toString().substring(doc.toString().indexOf("\"thumbnail_url\":\"") + 17);
        text = text.substring(0, text.indexOf("\""));
        byte[] data = null;
        try {
            URL url = new URL(text);
            BufferedImage image = ImageIO.read(url);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", bos);
            data = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public String toString() {
        return this.artistName + " - " + this.name;
    }

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://open.spotify.com/oembed?url=spotify:track:6bc5scNUVa3h76T9nvpGIH").ignoreContentType(true).get();
        String text = doc.toString().substring(doc.toString().indexOf("\"thumbnail_url\":\"") + 17);
        System.out.println(text.substring(0, text.indexOf("\"")));
    }

}
