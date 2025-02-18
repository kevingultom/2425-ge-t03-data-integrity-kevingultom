package academic.model;
/**
 * @author 12S23001-Kevin Gultom
 * @author 12S23010-Tiffani Butar-butar
 */
public class Enrollments {

        private String id;
        private String nim;
        private String tahun;
        private String subject;
        private String None = "None";
    
        public Enrollments(String id, String nim, String tahun, String subject, String None) {
            this.id = id;
            this.nim = nim;
            this.tahun = tahun;
            this.subject = subject;
            this.None = None;
        }
        

        @Override 
        public String toString(){
            return  id + "|" + nim + "|" + tahun + "|" + subject + "|" + None;
        }
    
    }
        