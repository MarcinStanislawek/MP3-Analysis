package pl.mp3analysis.services;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import pl.mp3analysis.controller.RootController;
import pl.mp3analysis.model.Song;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private List<Song> songs = new ArrayList<>();

    public void readMp3s(Path path1, Path path2) throws InvalidDataException, UnsupportedTagException {
        Mp3File mp3File;

        try (DirectoryStream<Path> stream =
                     Files.newDirectoryStream(path1, "*.mp3")) {
            for (Path mp3: stream) {
                System.out.println(mp3.getFileName());
                mp3File = new Mp3File(mp3);
                printDataFromMp3(mp3File);
                readDataFromMp3(mp3File);

            }
        } catch (IOException x) {
            System.err.println(x);
        }
        createFile(path2);
        }

        public void readDataFromMp3(Mp3File mp3File){
            Song song = new Song(
                    mp3File.getId3v2Tag().getArtist(),
                    mp3File.getId3v2Tag().getYear(),
                    mp3File.getId3v2Tag().getTitle(),
                    mp3File.getId3v2Tag().getAlbum());

            songs.add(song);
        }

        public void printDataFromMp3(Mp3File mp3File){
            System.out.println("Artysta: " + mp3File.getId3v2Tag().getArtist());
            System.out.println("Tytuł: " + mp3File.getId3v2Tag().getTitle());
            System.out.println("Album: " + mp3File.getId3v2Tag().getAlbum());
            System.out.println("Rok wydania: " + mp3File.getId3v2Tag().getYear());
            System.out.println();
            //System.out.println("Waga pliku : " + mp3File.getId3v2Tag().get);
        }

        public void createFile(Path path2) {
            try {
                FileWriter fileWriter = new FileWriter(path2.toFile().getPath() + "\\description.txt");
                for (int i = 0; i < songs.toArray().length; i++) {
                    fileWriter.write(songs.get(i).toString());
                } fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
        }

    }


}
