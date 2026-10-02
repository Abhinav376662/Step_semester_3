public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;
    
    public AttendanceSheet(int maxStudents) {
        this.presentStudents = new String[maxStudents];
        this.count = 0;
    }
    
    public void markPresent(String name) {
        // Check if already present (avoid duplicates)
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return; // Already marked
            }
        }
        
        // Add if space available
        if (count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        }
    }
    
    public int getPresentCount() {
        return count;
    }
    
    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    // NO method returns the full array
}
