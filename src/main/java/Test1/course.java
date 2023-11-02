package Test1;


import java.util.Date;

public class course {
        private String name;
        private String code;
        private Date startDate;
        private Integer numberOfStudents;
        private Integer count;

 //     Constructors
        public course(){
        }
        public course(String name, String code, Date startDate, Integer numberOfStudents){
            this.name = name;
            this.code = code;
            this.startDate = startDate;
            this.numberOfStudents = numberOfStudents;
        }

//     Setters and getters
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
        public void setCode(String code){
            this.code = code;
        }
        public String getCode(){
            return code;
        }
        public void setStartDate(Date startDate){
            this.startDate = startDate;
        }
        public Date getStartDate(){
            return startDate;
        }
        public void setNumberOfStudents(Integer numberOfStudents){
            this.numberOfStudents = numberOfStudents;
        }
        public Integer getNumberOfStudents(){
            return numberOfStudents;
        }

        public boolean equals(course other){
            if (this.code == other.code){
                return true;
            }
            else{
                return false;
            }
        }

}
