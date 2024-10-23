package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class StudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stdId;
    private String firstName;
    private String lastName;
    private String age;
    private String grade;
    private String address;
    private String email;
    private String contact;
    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

}
