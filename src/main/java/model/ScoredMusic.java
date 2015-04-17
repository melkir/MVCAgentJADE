package model;

/**
 * Created by melkir on 16/04/15.
 */
public class ScoredMusic implements Comparable<ScoredMusic> {
    private int revelanceScore = 0;
    private Music music;

    public ScoredMusic() {
    }

    public ScoredMusic(Music music, CriteriaList crit) {
        this.music = music;
        calculateRevelance(crit);
    }

    private void calculateRevelance(CriteriaList list) {
        boolean title, album, genre, artist, note;
        title = !list.getTitle().isEmpty() && music.getTitre().equals(list.getTitle());
        album = !list.getAlbum().isEmpty() && music.getAlbum().equals(list.getAlbum());
        genre = !list.getGenre().isEmpty() && music.getGenre().equals(list.getGenre());
        artist = !list.getArtist().isEmpty() && music.getArtist().equals(list.getArtist());
        note = !list.getNote().isEmpty() && (Integer.parseInt(music.getNote()) >= Integer.parseInt(list.getNote()));
        revelanceScore = ((title ? 1 : 0) + (album ? 1 : 0) + (genre ? 1 : 0) + (artist ? 1 : 0) + (note ? 1 : 0));
    }

    public Music getMusic() {
        return music;
    }

    public int getRevelanceScore() {
        return revelanceScore;
    }

    public int compareTo(ScoredMusic other) {
        return Integer.compare(this.getRevelanceScore(), other.getRevelanceScore());
    }

    @Override
    public String toString() {
        return "[ music : " + music.toString() + ", revelance : " + revelanceScore + " ]";
    }
}
