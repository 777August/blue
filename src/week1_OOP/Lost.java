package week1_OOP;

public class Lost {
    private int date;//丢失时间，默认格式为年月日，如  20220713
    private String lostPlace;//丢失地点（捡到东西的地方）
    private String getPlace;//领取地点

    public Lost(){}

    public Lost(int date, String lostPlace, String getPlace) {
        this.date = date;
        this.lostPlace = lostPlace;
        this.getPlace = getPlace;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getLostPlace() {
        return lostPlace;
    }

    public void setLostPlace(String lostPlace) {
        this.lostPlace = lostPlace;
    }

    public String getGetPlace() {
        return getPlace;
    }

    public void setGetPlace(String getPlace) {
        this.getPlace = getPlace;
    }
}
