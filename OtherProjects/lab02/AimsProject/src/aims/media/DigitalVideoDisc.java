package aims.media;

public class DigitalVideoDisc {
    // Classifier (static) member - Section 16
    private static int nbDigitalVideoDiscs = 0;

    // Instance members
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Constructor 1: by title only
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 2: by category, title and cost
    public DigitalVideoDisc(String category, String title, float cost) {
        super();
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 3: by title, category, director and cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 4: all attributes
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Getters only (DVD is immutable after creation per requirements)
    public int getId()           { return id; }
    public String getTitle()     { return title; }
    public String getCategory()  { return category; }
    public String getDirector()  { return director; }
    public int getLength()       { return length; }
    public float getCost()       { return cost; }

    // setTitle used temporarily in TestPassingParameter (Section 15)
    public void setTitle(String title) { this.title = title; }

    // Classifier getter
    public static int getNbDigitalVideoDiscs() { return nbDigitalVideoDiscs; }

    @Override
    public String toString() {
        return "DVD - ID: " + id + " | Title: " + title
                + " | Category: " + category
                + " | Director: " + director
                + " | Length: " + length + " min"
                + " | Cost: " + cost + "$";
    }
}