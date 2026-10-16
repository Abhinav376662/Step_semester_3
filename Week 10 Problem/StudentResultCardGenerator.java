import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double average() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total / (double) marks.length;
    }

    char grade() {
        double avg = average();

        if (avg >= 75) {
            return 'B';
        } else if (avg >= 60) {
            return 'C';
        } else if (avg >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void printResultCard() {
        System.out.printf("%s: Average %.1f, Grade %c%n",
                name.toUpperCase(), average(), grade());
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student s1 = new Student("Asha", new int[]{80, 90, 70});
        Student s2 = new Student("Ravi", new int[]{60, 55, 50});

        s1.printResultCard();
        s2.printResultCard();

        sc.close();
    }
}
