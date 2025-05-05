package com.example.mainservice.mapper;

import com.example.mainservice.dto.CourseDTO;
import com.example.mainservice.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO toDto(Course course);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Course toEntity(CourseDTO courseDTO);
}
