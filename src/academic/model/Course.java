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

    
        @Override 
        public String toString(){
            return id + "|" + name + "|" + credits + "|" + grade;
        }
    
    }
        