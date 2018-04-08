package com.mindyourownbusiness.proj.salarycalculator;


import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class EmployeeSalary {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull BigInteger salaryPaid;
    private @NonNull BigDecimal superPercent;
    private @NonNull Date paymentDate;
    private @NonNull PaymentType paymentType = PaymentType.Monthly;
}
