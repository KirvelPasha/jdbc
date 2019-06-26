package entity;

public class Apartment extends BaseEntity {

    private int number;
    private int countRooms;
    private int countPlaces;
    private int price;
    private Integer typeId;

    public Apartment(Integer id, int number, int countRooms,
                     int countPlaces, int price, Integer typeId) {
        super(id);
        this.number = number;
        this.countRooms = countRooms;
        this.countPlaces = countPlaces;
        this.price = price;
        this.typeId = typeId;
    }

    public Apartment() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCountRooms() {
        return countRooms;
    }

    public void setCountRooms(int countRooms) {
        this.countRooms = countRooms;
    }

    public int getCountPlaces() {
        return countPlaces;
    }

    public void setCountPlaces(int countPlaces) {
        this.countPlaces = countPlaces;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id='" + getId() + '\'' +
                "number=" + number +
                ", countRooms=" + countRooms +
                ", countPlaces=" + countPlaces +
                ", price=" + price +
                ", typeId=" + typeId +
                '}';
    }

}
