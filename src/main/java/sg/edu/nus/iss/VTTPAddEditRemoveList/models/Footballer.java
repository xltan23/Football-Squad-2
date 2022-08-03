package sg.edu.nus.iss.VTTPAddEditRemoveList.models;

import java.util.UUID;

public class Footballer {
    private String id;
    private String fullName;
    private String position;
    private String ratings;

    public Footballer() {
        //this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public Footballer(String id, String fn, String p, String r) {
        this.id = id;
        this.fullName = fn;
        this.position = p;
        this.ratings = r;
    }

    public Footballer(String fn, String p, String r) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.fullName = fn;
        this.position = p;
        this.ratings = r;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }


    @Override
    public String toString() {
        return "Footballer [fullName=" + fullName + ", id=" + id + ", position=" + position + ", ratings=" + ratings
                + "]";
    }

}


