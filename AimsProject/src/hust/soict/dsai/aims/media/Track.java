package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength()   { return length; }

    @Override
    public void play() throws PlayerException {
        if (length > 0) {
            System.out.println("Playing track: " + title + " - Length: " + length);
        } else {
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("ERROR: Track \"" + title + "\" length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track t = (Track) o;
        return this.title.equals(t.title) && this.length == t.length;
    }

    @Override
    public String toString() {
        return "Track: " + title + " (" + length + " min)";
    }
}
