package models;

public class CargoModel {
    private int car_id;
    private String car_nombre;
    private String car_description;

    public CargoModel(int car_id, String car_nombre, String car_description) {
        this.car_id = car_id;
        this.car_nombre = car_nombre;
        this.car_description = car_description;
    }

    public int getCar_id() {
        return car_id;
    }

    public String getCar_nombre() {
        return car_nombre;
    }

    public void setCar_nombre(String car_nombre) {
        this.car_nombre = car_nombre;
    }

    public String getCar_description() {
        return car_description;
    }

    public void setCar_description(String car_description) {
        this.car_description = car_description;
    }

}
