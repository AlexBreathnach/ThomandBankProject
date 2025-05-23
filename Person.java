import java.time.LocalDate;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String address;
    protected LocalDate dob;

    public Person(
            String firstName,
            String lastName,
            String address,
            LocalDate dob)
    {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
