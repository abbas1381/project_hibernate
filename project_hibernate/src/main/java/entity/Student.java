package entity;

import base.domin.BaseEntity;
import entity.enumuration.MarriedOrSingle;
import entity.enumuration.SectionOfStudy;
import entity.enumuration.UniversityType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static menu.Menu.generateRandomPassword;

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
    Integer BirthCertificateNumber;
    String nationalCode;
    LocalDate dateOfBirth;
    String universityName;
    Integer term;
    LocalDate enterYear;
    Boolean gettingLoan;
    Boolean HavingDorm;
    @Column(nullable = true)
    LocalDate lastLoanDate;
    String city;

    String userName;
    String password;

    @Enumerated(value = EnumType.STRING)
    UniversityType universityType;

    @Enumerated(value = EnumType.STRING)
    SectionOfStudy sectionOfStudy;

    @Enumerated(value = EnumType.STRING)
    MarriedOrSingle marriedOrSingle;

    @OneToMany(mappedBy = "student")
    List<Card> cards;

    @OneToMany(mappedBy = "student")
    List<Loan> loans;

    public Student(Integer integer) {
        super(integer);
    }

    public Student(String firstName, String lastName, String motherName, Integer birthCertificateNumber,
                   String nationalCode, LocalDate dateOfBirth, String universityName, Integer term, LocalDate enterYear,
                   Boolean gettingLoan, Boolean havingDorm, LocalDate lastLoanDate,
                   UniversityType universityType, SectionOfStudy sectionOfStudy,
                   MarriedOrSingle marriedOrSingle, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.motherName = motherName;
        this.BirthCertificateNumber = birthCertificateNumber;
        this.nationalCode = nationalCode;
        this.dateOfBirth = dateOfBirth;
        this.universityName = universityName;
        this.term = term;
        this.enterYear = enterYear;
        this.gettingLoan = gettingLoan;
        this.HavingDorm = havingDorm;
        this.lastLoanDate=lastLoanDate;
        this.userName = nationalCode;
        this.password = generateRandomPassword();
        this.universityType = universityType;
        this.sectionOfStudy = sectionOfStudy;
        this.marriedOrSingle = marriedOrSingle;
        this.city=city;
    }

}
