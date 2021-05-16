package by.deniskonnov.RestAPI.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
@ApiModel(value = "Employee entity")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "departmentId")
    private Long departmentId;

    @Column(name = "fullName")
    @ApiModelProperty(value = "Employee's full name", example = "Komarov Victor Igorevich")
    private String fullName;

    @Column(name = "dateOfBirth")
    @ApiModelProperty(value = "Employee's date of birth", example = "1995-05-05")
    private String dateOfBirth;

    @Column(name = "emailAddress")
    @ApiModelProperty(value = "Employee's email", example = "igor@gmail.com")
    private String emailAddress;

    @Column(name = "position")
    @ApiModelProperty(value = "Employee's position", example = "Developer")
    private String position;

    @Column(name = "dateOfEmployment")
    @ApiModelProperty(value = "Employee's release date for work", example = "2011-11-11")
    private String dateOfEmployment;
}
