package pl.mp3analysis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Song {
    private String artist;
    private String year;
    private String title;
    private String album;

    //private String size;


    @Override
    public String toString() {
        return "Song{" +
                "artist='" + artist + '\'' +
                ", year='" + year + '\'' +
                ", album='" + album + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
