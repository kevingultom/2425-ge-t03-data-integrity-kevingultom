package academic.model;
/**
 * @author 12S23001-Kevin Gultom
 * @author 12S23010-Tiffani Butar-butar
 */
public class Student {

    // class definition
        private String id;
        private String name;
        private int tahun;
        private String  prodi;
    
        public Student(String id, String name, int tahun, String prodi) {
            this.id = id;
            this.name = name;
            this.tahun = tahun;
            this.prodi = prodi;
        }

    
        @Override 
        public String toString(){
            return id + "|" + name + "|" + tahun + "|" + prodi;
        }
    
    }
        