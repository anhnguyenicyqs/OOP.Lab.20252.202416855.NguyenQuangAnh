package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
    private static int nbMedias = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
        Comparator.comparing(Media::getTitle).thenComparing(Comparator.comparing(Media::getCost).reversed());

    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
        Comparator.comparing(Media::getCost).reversed().thenComparing(Media::getTitle);

    public Media() {
        nbMedias++;
        this.id = nbMedias;
    }

    public Media(String title, String category, float cost) {
        this();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId()          { return id; }
    public String getTitle()    { return title; }
    public String getCategory() { return category; }
    public float getCost()      { return cost; }
    public void setTitle(String title)       { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setCost(float cost)          { this.cost = cost; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Media)) return false;
        Media media = (Media) o;
        return this.title != null && this.title.equals(media.title)
                && Float.compare(this.cost, media.cost) == 0;
    }

    @Override
    public int compareTo(Media other) {
        if (other == null) throw new NullPointerException("Cannot compare to null Media");
        int cmp = this.title == null ? -1 : this.title.compareTo(
                other.title == null ? "" : other.title);
        if (cmp != 0) return cmp;
        return Float.compare(this.cost, other.cost);
    }

    public boolean isMatch(String title) {
        return this.title != null && this.title.toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public abstract String toString();
}
