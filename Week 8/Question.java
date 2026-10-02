import java.util.Scanner;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;
    
    public Question(String questionText, String correctAnswer, 
                    String studentAnswer, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }
    
    public abstract double getScore();
    public abstract String getType();
}

class MCQ extends Question {
    public MCQ(String questionText, String correctAnswer, 
               String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }
    
    @Override
    public double getScore() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
    
    @Override
    public String getType() {
        return "MCQ";
    }
}

class TF extends Question {
    public TF(String questionText, String correctAnswer, 
              String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }
    
    @Override
    public double getScore() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
    
    @Override
    public String getType() {
        return "TF";
    }
}

class Essay extends Question {
    public Essay(String questionText, String correctAnswer, 
                 String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }
    
    @Override
    public double getScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        
        for (String keyword : keywords) {
            String cleanKeyword = keyword.trim().toLowerCase();
            if (studentAnswer.toLowerCase().contains(cleanKeyword)) {
                matchCount++;
            }
        }
        
        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        }
        return 0;
    }
    
    @Override
    public String getType() {
        return "ESSAY";
    }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline
        
        Question[] questions = new Question[n];
        double totalScore = 0;
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = parseInput(line);
            
            String type = parts[0];
            String questionText = parts[1].replace("\"", "");
            String correctAnswer = parts[2].replace("\"", "");
            String studentAnswer = parts[3].replace("\"", "");
            int points = Integer.parseInt(parts[4]);
            
            if (type.equals("MCQ")) {
                questions[i] = new MCQ(questionText, correctAnswer, studentAnswer, points);
            } else if (type.equals("TF")) {
                questions[i] = new TF(questionText, correctAnswer, studentAnswer, points);
            } else if (type.equals("ESSAY")) {
                questions[i] = new Essay(questionText, correctAnswer, studentAnswer, points);
            }
        }
        
        for (Question q : questions) {
            double score = q.getScore();
            totalScore += score;
            System.out.printf("%s: %.2f%n", q.getType(), score);
        }
        
        System.out.printf("Total Score: %.2f%n", totalScore);
        sc.close();
    }
    
    private static String[] parseInput(String line) {
        // Simple parser for the input format
        String[] result = new String[5];
        int idx = 0;
        
        // Get type
        int spaceIdx = line.indexOf(" ");
        result[0] = line.substring(0, spaceIdx);
        line = line.substring(spaceIdx + 1);
        
        // Parse quoted strings and number
        int quoteCount = 0;
        int start = 0;
        int partIdx = 1;
        
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '"') {
                quoteCount++;
                if (quoteCount == 2) {
                    result[partIdx++] = line.substring(start + 1, i);
                    start = i + 1;
                    quoteCount = 0;
                    if (partIdx == 4) {
                        result[4] = line.substring(i + 1).trim();
                        break;
                    }
                } else {
                    start = i;
                }
            }
        }
        
        return result;
    }
}
