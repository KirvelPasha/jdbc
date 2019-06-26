package entity;

public class Comments  extends  BaseEntity{

    private String comment;
    private Integer apartmentId;
    private Integer personId;

    public Comments(Integer id, String comment,
                    Integer apartmentId, Integer personId) {
        super(id);
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

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
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
