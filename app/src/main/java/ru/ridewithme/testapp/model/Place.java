package ru.ridewithme.testapp.model;

/**
 * Created by idbolshakov on 26.02.16.
 *
 * Информация о месте проведения события Withme
 */
public class Place {

    // СВОЙСТВА

    private final static String DESCRIPTION_NOT_SET = "нет описания";

    private int id;
    private String title;
    private double latitude;
    private double longitude;
    private String description;



    // КОНСТРУКТОРЫ

    public Place() {
        super();
    }

    public Place(
            int id,
            String title,
            double latitude,
            double longitude,
            String description
    ) {

        super();

        setId(id);
        setTitle(title);
        setLatitude(latitude);
        setLongitude(longitude);
        setDescription(description);

    }



    // ИНТЕРФЕЙС КЛАССА (PUBLIC МЕТОДЫ)

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }


    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }


    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() {
        return this.latitude;
    }


    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return this.longitude;
    }


    public void setDescription(String description) { this.description = description != "null" ? description : DESCRIPTION_NOT_SET; }

    public String getDescription() { return this.description; }
}
