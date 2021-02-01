package downloader.download;

import java.io.File;
import java.io.IOException;

import com.github.kiulian.downloader.*;
import com.github.kiulian.downloader.model.*;

public class Download {

    private static void getAllFiles(File curDir) {

        File[] filesList = curDir.listFiles();
        for (File f : filesList) {
            if (f.isDirectory())
                System.out.println(f.getName());
            if (f.isFile()) {
                System.out.println(f.getName());
            }
        }
    }

    private static String getID(String url) {
        return url.substring(url.lastIndexOf("=") + 1);
    }

    public static File download(String youtubeLink) throws YoutubeException, IOException {
        YoutubeDownloader downloader = new YoutubeDownloader();
        YoutubeVideo video = null;
        video = downloader.getVideo(Download.getID(youtubeLink));
        File outputDir = new File(".");
        File outFile = video.download(video.formats().get(0), outputDir);
        return outFile;
    }

    public static void main(String[] args) {
        String testString = "https://www.youtube.com/watch?v=Wch3gJG2GJ4";
        try {
            download(testString);
        } catch (YoutubeException | IOException e) {
            e.printStackTrace();
        }
        getAllFiles(new File("."));
    }
}
