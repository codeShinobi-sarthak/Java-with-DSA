package genirics.comparing;

public class Student implements Comparable<Student>{
    int rollNo;
    float marks;

    public Student(int rollNo, float marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return marks + "";
    }

    @Override
    public int compareTo(Student st) {
        int diff = (int)(this.marks - st.marks);

        // if diff == 0: means both are equal
        // if diff < 0: means o is bigger else o is smaller

        return diff;
    }
}