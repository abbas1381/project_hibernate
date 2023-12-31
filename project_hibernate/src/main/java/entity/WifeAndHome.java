package entity;

import base.domin.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WifeAndHome extends BaseEntity<Integer> {

    String firstName;
    String lastName;
    String locationOfHouse;
    String numberOfRentHouse;

    @OneToOne
    Student student;


    public WifeAndHome(Integer integer, String firstName, String lastName, String locationOfHouse, String numberOfRentHouse, Student student) {
        super(integer);
        this.firstName = firstName;
        this.lastName = lastName;
        this.locationOfHouse = locationOfHouse;
        this.numberOfRentHouse = numberOfRentHouse;
        this.student = student;
    }
}
