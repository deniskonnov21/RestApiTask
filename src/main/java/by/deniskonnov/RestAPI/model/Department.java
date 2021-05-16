package by.deniskonnov.RestAPI.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "department")
@Getter
@Setter
@ToString
@ApiModel(value = "Department entity")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @ApiModelProperty(value = "Department name", example = "Developers")
    private String name;

    @Column(name = "description")
    @ApiModelProperty(value = "Description of the department")
    private String description;

    @Column(name = "phoneNumber")
    @ApiModelProperty(value = "Phone number of the department", example = "80172397687")
    private String phoneNumber;

    @Column(name = "dateOfFormation")
    @ApiModelProperty(value = "Date of formation of the department", example = "2011-11-11")
    private String dateOfFormation;

    @Column(name = "oneOrManyEmployees")
    @ApiModelProperty(value = "How many employees include of the department", example = "10")
    private int oneOrManyEmployees;
}
