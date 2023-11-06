public class StudentDataProcessor {
    public static void main(String[] args) {
        // Define the student data as a string
        String studentData = "John:85, Alice:92, Bob:78, Carol:95, David:88, Emma:79, Frank:90";

        // Split the student records into an array
        String[] studentRecords = studentData.split(", ");
        int numStudents = studentRecords.length;

        // Create arrays to store student names and scores
        String[] studentNames = new String[numStudents];
        int[] studentScores = new int[numStudents];

        // Populate the arrays with data from the split records
        for (int i = 0; i < numStudents; i++) {
            String[] parts = studentRecords[i].split(":");
            studentNames[i] = parts[0];
            studentScores[i] = Integer.parseInt(parts[1]);
        }

        // Initialize variables for calculations
        int totalScore = 0;
        int highestScore = Integer.MIN_VALUE;
        int lowestScore = Integer.MAX_VALUE;
        String topScorer = "";
        String lowestScorer = "";

        // Calculate total score, highest and lowest scores
        for (int i = 0; i < numStudents; i++) {
            int score = studentScores[i];
            totalScore += score;

            // Check for the highest score
            if (score > highestScore) {
                highestScore = score;
                topScorer = studentNames[i];
            }

            // Check for the lowest score
            if (score < lowestScore) {
                lowestScore = score;
                lowestScorer = studentNames[i];
            }
        }

        // Calculate the average score
        float averageScore = (float) totalScore / numStudents;

        // Display the results
        displayResults(numStudents, averageScore, topScorer, highestScore, lowestScorer, lowestScore);
    }

    private static void displayResults(int numStudents, float averageScore, String topScorer, int highestScore, String lowestScorer, int lowestScore) {
        System.out.println("Student Data Processing Results:");
        System.out.println("Total number of students: " + numStudents);
        System.out.println("Average marks of all students: " + averageScore);
        System.out.println("Student with the highest score: " + topScorer + " : " + highestScore);
        System.out.println("Student with the lowest score: " + lowestScorer + " : " + lowestScore);
    }
}
