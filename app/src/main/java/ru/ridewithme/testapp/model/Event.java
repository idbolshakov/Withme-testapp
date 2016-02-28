package ru.ridewithme.testapp.model;

/**
 * Created by idbolshakov on 26.02.16.
 *
 * Информация о событии Witme
 */
public class Event implements Comparable<Event> {

    // СВОЙСТВА

    private final static String END_DATETIME_NOT_SET = "не указано";

    private int id;
    private String title;
    private String beginDatetime;
    private String endDatetime;
    private Place place;
    private int maxPeople;
    private int amountOfFollowers;
    private String sportName;
    private String sportImageURL;



    // КОНСТРУКТОРЫ

    public Event() {
        super();
    }

    public Event(
            int id,
            String title,
            String beginDatetime,
            String endDatetime,
            Place place,
            int maxPeople,
            int amountOfFollowers,
            String sportName,
            String sportImageURL
    ) {

        super();

        setId(id);
        setTitle(title);
        setBeginDatetime(beginDatetime);
        setEndDatetime(endDatetime);
        setPlace(place);
        setmaxPeople(maxPeople);
        setAmountOfFollowers(amountOfFollowers);
        setSportName(sportName);
        setSportImageURL(sportImageURL);
    }



    // ИНТЕРФЕЙС КЛАССА (PUBLIC МЕТОДЫ)

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }


    public void setBeginDatetime(String beginDatetime) {
        this.beginDatetime = beginDatetime.substring(0, 16);// без секунд
    }

    public String getBeginDatetime() {
        return this.beginDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = (endDatetime.length() == 19) ? endDatetime.substring(0, 16) : END_DATETIME_NOT_SET; // без секунд
    }

    public String getEndDatetime() {
        return this.endDatetime;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Place getPlace() {
        return this.place;
    }


    public void setmaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getMaxPeople() {
        return this.maxPeople;
    }


    public void setAmountOfFollowers(int amountOfFollowers) {
        this.amountOfFollowers = amountOfFollowers;
    }

    public int getAmountOfFollowers() {
        return this.amountOfFollowers;
    }


    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getSportName() {
        return this.sportName;
    }


    public void setSportImageURL(String sportImageURL) {
        this.sportImageURL = sportImageURL;
    }

    public String getSportImageURL() {
        return this.sportImageURL;
    }


    public String getGroupInfo() {
        return generateGroupInfo();
    }


    public int compareTo(Event other) { // логика сортировки

        if ( other.getId() < this.getId() ) {

            return -1;

        } else if (other.getId() < this.getId()) {

            return 1;
        } else {

            return 0;
        }
    }



    // РЕАЛИЗАЦИЯ КЛАССА (PRIVATE МЕТОДЫ)

    private String generateGroupInfo() {

        if (this.getMaxPeople() == 0) { // Если не задано максимальное число участников

            return Integer.toString(this.getAmountOfFollowers());

        } else {

            return Integer.toString(this.getAmountOfFollowers()) + "/" + Integer.toString(this.getMaxPeople());
        }
    }
}
