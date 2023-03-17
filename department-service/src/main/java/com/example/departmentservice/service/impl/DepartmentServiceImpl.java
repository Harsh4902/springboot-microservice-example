package com.example.departmentservice.service.impl;

import com.example.departmentservice.dtos.DepartmentDto;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = Department.builder()
                .id(departmentDto.getId())
                .departmentName(departmentDto.getDepartmentName())
                .departmentDescription(departmentDto.getDepartmentDescription())
                .departmentCode(departmentDto.getDepartmentCode())
                .build();

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentDto.builder()
                .id(savedDepartment.getId())
                .departmentName(savedDepartment.getDepartmentName())
                .departmentDescription(savedDepartment.getDepartmentDescription())
                .departmentCode(savedDepartment.getDepartmentCode())
                .build();

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentbyCode(String departmentCode) {
        Department getDepartment = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto getDepartmentDto = DepartmentDto.builder()
                .id(getDepartment.getId())
                .departmentName(getDepartment.getDepartmentName())
                .departmentDescription(getDepartment.getDepartmentDescription())
                .departmentCode(getDepartment.getDepartmentCode())
                .build();

        return getDepartmentDto;
    }
}
