package project4;

public class classSection implements Comparable<classSection> {
    private int ClassNumber;
    private String CourseSubject;
    private int CatalogNumber;
    private String ClassTitle;
    private String Level;

    public classSection() {
    }

    public classSection(int classNumber, String courseSubject, int catalogNumber, String classTitle, String level) {
        ClassNumber = classNumber;
        CourseSubject = courseSubject;
        CatalogNumber = catalogNumber;
        ClassTitle = classTitle;
        Level = level;
    }

    public int getClassNumber() {
        return ClassNumber;
    }

    public void setClassNumber(int classNumber) {
        ClassNumber = classNumber;
    }

    public String getCourseSubject() {
        return CourseSubject;
    }

    public void setCourseSubject(String courseSubject) {
        CourseSubject = courseSubject;
    }

    public int getCatalogNumber() {
        return CatalogNumber;
    }

    public void setCatalogNumber(int catalogNumber) {
        CatalogNumber = catalogNumber;
    }

    public String getClassTitle() {
        return ClassTitle;
    }

    public void setClassTitle(String classTitle) {
        ClassTitle = classTitle;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    @Override
    public String toString() {
        return "classSection{" +
                "ClassNumber=" + ClassNumber +
                ", CourseSubject='" + CourseSubject + '\'' +
                ", CatalogNumber=" + CatalogNumber +
                ", DataStructures='" + ClassTitle + '\'' +
                ", Level='" + Level + '\'' +
                '}';
    }



    @Override
    public int compareTo(classSection o) {
        return this.getClassNumber()-o.getClassNumber();
    }
}
