package academic.model;
/**
 * @author 12S23001-Kevin Gultom
 * @author 12S23010-Tiffani Butar-butar
 */
public class Course {

    // class definition
        private String id;
        private String name;
        private int credits;
        private String  grade;
    
        public Course(String id, String name, int credits, String grade) {
            this.id = id;
            this.name = name;
            this.credits = credits;
            this.grade = grade;
        }
        // Getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    // Setter
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
        @Override 
        public String toString(){
            return id + "|" + name + "|" + credits + "|" + grade;
        }
    
    }
        