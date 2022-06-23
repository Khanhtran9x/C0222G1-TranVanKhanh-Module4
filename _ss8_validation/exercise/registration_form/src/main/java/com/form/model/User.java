package com.form.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity(name = "user")
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Pattern(regexp = "^[A-Za-z]{2,45}$", message = "Wrong first name format")
    private String firstName;
    @Pattern(regexp = "^[A-Za-z\\s]{2,45}$", message = "Wrong last name format")
    private String lastName;
    @Pattern(regexp = "(090)[\\d]{7}|(091)[\\d]{7}", message = "Wrong phone number format")
    private String phoneNumber;
    private String dateOfBirth;
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}", message = "Wrong email format")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
         User user = (User) target;
         String regexDate = "\\d{4}(-)(([0][1-9])|([1][0,2]))(-)(([0-2][0-9])|([3][0-1]))";
         if (!user.dateOfBirth.matches(regexDate)){
             errors.rejectValue("dateOfBirth", "dateOfBirth.invalidFormat");
         } else {
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             LocalDate dateOfBirth = LocalDate.parse(user.dateOfBirth, dtf);
             LocalDate now = LocalDate.now().plusYears(-18);
             if (now.isBefore(dateOfBirth)){
                 errors.rejectValue("dateOfBirth", "dateOfBirth.invalidAge");
             }
         }
    }
}
