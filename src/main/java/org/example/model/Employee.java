package org.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author sksingh created on 05/01/24
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Employee extends Person {

    private String code;
}
