package entity;

public class ApartmentTypes extends BaseEntity {
    private String type;

    public ApartmentTypes(String type) {
        this.type = type;
    }

    public ApartmentTypes() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ApartmentTypes{" +
                "id='" + getId() + '\'' +
                "type='" + type + '\'' +
                '}';
    }
}
