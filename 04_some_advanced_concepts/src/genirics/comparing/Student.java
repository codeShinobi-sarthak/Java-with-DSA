package genirics.comparing;

public class Student implements Comparable<Student> {
    int rollNo;
    float marks;

    public Student(int rollNo, float marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // can change the return value (rollNo <-> marks)
    // even both can be returned
    @Override
    public String toString() {
        return "RollNo: " + rollNo + ", Marks: " + marks;
    }

    @Override
    public int compareTo(Student st) {

        // if diff == 0: means both are equal
        // if diff < 0: means o is bigger else o is smaller

        return (int) (this.marks - st.marks);
    }
}