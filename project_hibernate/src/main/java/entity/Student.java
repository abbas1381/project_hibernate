package entity;

import base.domin.BaseEntity;
import entity.enumuration.MarriedOrSingle;
import entity.enumuration.SectionOfStudy;
import entity.enumuration.UniversityType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Student extends BaseEntity<Integer> {

    String firstName;
    String lastName;
    String motherName;
    String BirthCertificateNumber;
    String nationalCode;
    LocalDate dateOfBirth;
    String universityName;
    Integer term;
    String enterYear;
    Boolean gettingLoan;
    Boolean HavingDorm;
    Date lastLoanDate;
    String city;

    String userName=nationalCode;
    String password;

    @Enumerated
    UniversityType universityType;

    @Enumerated
    SectionOfStudy sectionOfStudy;

    @Enumerated
    MarriedOrSingle marriedOrSingle;

    @OneToMany(mappedBy = "student")
    List<Card> cards;

    @OneToMany(mappedBy = "student")
    List<Loan> loans;

    public Student(Integer integer, String firstName, String lastName, String motherName, String birthCertificateNumber,
                   String nationalCode, LocalDate dateOfBirth, String universityName, Integer term, String enterYear,
                   Boolean gettingLoan, Boolean havingDorm, String userName, String password,
                   UniversityType universityType, SectionOfStudy sectionOfStudy,
                   MarriedOrSingle marriedOrSingle,Date lastLoanDate,String city) {
        super(integer);
        this.firstName = firstName;
        this.lastName = lastName;
        this.motherName = motherName;
        BirthCertificateNumber = birthCertificateNumber;
        this.nationalCode = nationalCode;
        this.dateOfBirth = dateOfBirth;
        this.universityName = universityName;
        this.term = term;
        this.enterYear = enterYear;
        this.gettingLoan = gettingLoan;
        HavingDorm = havingDorm;
        this.userName = nationalCode;
        this.password = password;
        this.universityType = universityType;
        this.sectionOfStudy = sectionOfStudy;
        this.marriedOrSingle = marriedOrSingle;
        this.lastLoanDate=lastLoanDate;
        this.city=city;
    }

    public void setPassword(String password) {
        // Validate the password against the specified criteria
        String passwordPattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%&])[A-Za-z\\d@#$%&]{8,}";
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            this.password = password;
        } else {
            System.out.println("Invalid password! Password must contain at least one lowercase letter, one uppercase letter, one digit, one special character (@#$%&), and be at least eight characters long.");
        }
    }

}
