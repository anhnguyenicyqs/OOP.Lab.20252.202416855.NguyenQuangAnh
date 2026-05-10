package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String director, String artist, float cost) {
        super(title, category, director, 0, cost);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    @Override
    public int getLength() {
        int total = 0;
        for (Track t : tracks) total += t.getLength();
        return total;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" already exists in this CD.");
        } else {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" added.");
        }
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" not found in this CD.");
        } else {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "\" removed.");
        }
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle() + " - Length: " + getLength());
        for (Track t : tracks) t.play();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - ").append(getTitle()).append(" - ").append(getCategory())
          .append(" - ").append(artist).append(" - ").append(getDirector())
          .append(" - ").append(getLength()).append(" min - ").append(getCost()).append(" $\n");
        for (Track t : tracks) sb.append("  ").append(t.toString()).append("\n");
        return sb.toString();
    }
}
