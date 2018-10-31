package theme4_classes_and_objects.task25.financeElements;

import java.time.LocalDate;
/*Пользователь*/
public class User {
    private final String name;
    private final String surname;
    private final String nameByFather;
    private final LocalDate dateOfBirth;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNameByFather() {
        return nameByFather;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    private final String nationality;

    public User(String name, String surname, String nameByFather, LocalDate dateOfBirth, String nationality) {
        this.name = name;
        this.surname = surname;
        this.nameByFather = nameByFather;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }
}
