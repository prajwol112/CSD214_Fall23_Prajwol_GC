package lab1.q3;

public class Person {
    private String firstname;
    private String lastname;
    public enum Gender{M,F,Other}; /** enumerater rfor the gender */
    private Gender gender;
    private String sin;




    /**count the number of person objects
     * increment the count when a new person object is created and decrement when a person object is deleted
     */
    public static int count = 0;
    public Person(){
        count++;
    }
    public void deletePerson(){
        count--;
    }

    public Person (String firstname, String lastname,Gender gender, String sin){
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.sin = sin;
        count++;
    }

    public String toString(){
        return "{ "+ firstname + " " + lastname + " " + gender + " " + sin + " }";
    }


}
