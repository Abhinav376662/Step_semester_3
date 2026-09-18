// M1. Student Placement Record Management
class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    public void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

// M2. Hostel Mess Wallet Management
class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Negative opening balance not allowed. Starting at 0.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be positive");
        } else {
            balance += amount;
            System.out.println("Balance after top-up: " + balance);
        }
    }

    public void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

// M3. Course Credit Management
class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }
}

// M4. Library ID Card Management
class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

// M5. Student and College Information Management
class Student {
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

// Main class to test all modules
public class PlacementAndStudentManagement {
    public static void main(String[] args) {
        // M1 Test
        System.out.println("=== M1: Student Placement Record Management ===");
        PlacementRecord[] records = new PlacementRecord[3];
        records[0] = new PlacementRecord("Ravi", "TCS", 4.5);
        records[1] = new PlacementRecord("Anitha", "Zoho", 6.2);
        records[2] = new PlacementRecord("Karthik", "Infosys", 4.0);

        for (PlacementRecord record : records) {
            record.printRecord();
        }

        // M2 Test
        System.out.println("\n=== M2: Hostel Mess Wallet Management ===");
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());

        // M3 Test
        System.out.println("\n=== M3: Course Credit Management ===");
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);
        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(theoryCourse.code + " total credits: " + theoryCourse.totalCredits());
        System.out.println(labCourse.code + " total credits: " + labCourse.totalCredits());

        // M4 Test
        System.out.println("\n=== M4: Library ID Card Management ===");
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi;
        duplicate.booksIssued = 3;
        IdCard separate = new IdCard("Ravi", 3);

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));

        // M5 Test
        System.out.println("\n=== M5: Student and College Information Management ===");
        Student s1 = new Student("Alice", 95);
        Student s2 = new Student("Bob", 92);
        Student.printCollegeInfo();
    }
}
