package hust.soict.dsai.aims.media;

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
    public void play() {
        if (length <= 0) {
            System.out.println("ERROR: Track \"" + title + "\" cannot be played (invalid length).");
            return;
        }
        System.out.println("Playing track: " + title + " - Length: " + length);
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
