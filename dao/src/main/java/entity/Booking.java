package entity;

import java.util.*;

public class Booking extends BaseEntity{

    private String startDate;
    private String endDate;
    private int personId;
    private int apartmentId;


    public Booking(String startDate, String endDate, int personId, int apartmentId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.personId = personId;
        this.apartmentId = apartmentId;
    }


    public Booking() {
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }



    @Override
    public String toString() {
        return "Booking{" +
                "id='" + getId() + '\'' +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", apartments=" + apartmentId +
                '}';
    }
}
