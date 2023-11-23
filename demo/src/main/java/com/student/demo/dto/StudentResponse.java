package com.student.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
//@Builder
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    public Long id;
    public String name ;
    public Integer age;
    public Double salary;

}
