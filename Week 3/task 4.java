import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

// Comparator for sorting students
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Sort by CGPA descending
        if (s1.getCgpa() != s2.getCgpa()) {
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        }
        // If CGPA equal, sort by first name ascending
        int nameComp = s1.getFname().compareTo(s2.getFname());
        if (nameComp != 0) {
            return nameComp;
        }
        // If first name also equal, sort by ID ascending
        return s1.getId() - s2.getId();
    }
}

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();

        while(testCases > 0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        // Sort using custom comparator
        Collections.sort(studentList, new StudentComparator());

        // Print sorted student names
        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}
