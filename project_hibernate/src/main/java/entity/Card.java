package entity;

import base.domin.BaseEntity;
import entity.enumuration.NameOfBank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Card extends BaseEntity<Integer> {

    @Enumerated
    NameOfBank nameOfBank;

    LocalDate expiredDate;

    Integer cvv2;

    @ManyToOne
    @JoinColumn(name = "student_id")

    Student student;

}
