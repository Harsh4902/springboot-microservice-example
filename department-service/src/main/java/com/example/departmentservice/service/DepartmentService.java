package com.example.departmentservice.service;

import com.example.departmentservice.dtos.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentbyCode(String departmentCode);

}
