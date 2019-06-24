package entity;

public class Comments  extends  BaseEntity{
    private String comment;
    private int apartmentId;
    private int personId;

    public Comments(String comment, int apartmentId, int personId) {
        this.comment = comment;
        this.apartmentId = apartmentId;
        this.personId = personId;
    }

    public Comments() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "comment='" + comment + '\'' +
                ", apartmentId=" + apartmentId +
                ", personId=" + personId +
                '}';
    }
}
