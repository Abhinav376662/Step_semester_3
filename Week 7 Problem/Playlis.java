public class Playlist {
    private final String[] songs;
    private int songCount;
    
    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.songCount = 0;
    }
    
    public void addSong(String title) {
        if (songCount < songs.length) {
            songs[songCount] = title;
            songCount++;
        }
        // Extra songs beyond max are ignored
    }
    
    public String[] getSongs() {
        // Return a copy, not the original array
        String[] copy = new String[songCount];
        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }
    
    public int getSongCount() {
        return songCount;
    }
}
