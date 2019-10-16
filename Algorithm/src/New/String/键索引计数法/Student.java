package New.String.键索引计数法;

public class Student {
    private String name;
    private int groupNo;

    public Student(String name, int groupNo) {
        this.name = name;
        this.groupNo = groupNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int key() {
        return groupNo;
    }

    public void setGroupNo(int groupNo) {
        this.groupNo = groupNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", groupNo=" + groupNo +
                '}';
    }
}
