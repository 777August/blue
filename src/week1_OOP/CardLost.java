package week1_OOP;

public class CardLost extends Lost {
    private String name;
    private int number;//学号
    private int grade;//年级
    private String college;//学院
    //记不得一卡通上具体有什么了
    public CardLost(){}

    public CardLost(int date, String lostPlace, String getPlace, String name, int number, int grade, String college) {
        super(date, lostPlace, getPlace);
        this.name = name;
        this.number = number;
        this.grade = grade;
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "丢失时间:" + getDate() +
                "\t丢失地点: " + getLostPlace() +
                "\t领取地点: " +getGetPlace() +
                "\n姓名:" + name +
                "\t学号: " + number +
                "\t年级: " + grade +
                "\t学院: " + college;
    }
}
