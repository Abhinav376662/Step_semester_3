import java.util.Scanner;

class Voting_Eligibility_Checker {

    static void checkVotingEligibility(int age) {
        if (age >= 18) {
            System.out.println("Eligible to vote.");

        } else {
            System.out.println("Not eligible to vote.");
        }
    }

    public static void main(String[] args) {
        Voting_Eligibility_Checker checker = new Voting_Eligibility_Checker();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your age : ");
        int age = sc.nextInt();
        checker.checkVotingEligibility(age);
    }
}