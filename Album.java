package songPlaylistApplication;

import java.util.*;

public class Album {

    private String name;
    private String artist;
    private List<Song> songs; 
	
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }
	
    public Song findSong(String title) {
        return songs.stream()
                    .filter(song -> song.getTitle().equals(title))
                    .findFirst()
                    .orElse(null);
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) != null) {
            System.out.println("Song with this name " + title + " already exists in the List");
            return false;
        }
        songs.add(new Song(title, duration));
        return true;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        if (trackNumber < 1 || trackNumber > songs.size()) {
            System.out.println("This album does not have a song with track number " + trackNumber);
            return false;
        }
        playlist.add(songs.get(trackNumber - 1));
        return true;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song song = findSong(title);
        if (song != null) {
            playlist.add(song);
            return true;
        }
        System.out.println("Song with title " + title + " not found in the album.");
        return false;
    }
}
