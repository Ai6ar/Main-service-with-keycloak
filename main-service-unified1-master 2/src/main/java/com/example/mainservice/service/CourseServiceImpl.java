package com.example.mainservice.service;

import com.example.mainservice.dto.CourseDTO;
import com.example.mainservice.entity.Course;
import com.example.mainservice.exception.ResourceNotFoundException;
import com.example.mainservice.mapper.CourseMapper;
import com.example.mainservice.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseDTO> getAllCourses() {
        log.info("Fetching all courses");
        return courseRepository.findAll().stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        log.debug("Fetching course by id: {}", id);
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id=" + id));
        return courseMapper.toDto(course);
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        log.info("Creating new course: {}", courseDTO.getName());
        Course course = courseMapper.toEntity(courseDTO);
        course.setCreatedAt(LocalDateTime.now());
        course.setUpdatedAt(LocalDateTime.now());
        return courseMapper.toDto(courseRepository.save(course));
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        log.info("Updating course with id {}: {}", id, courseDTO.getName());
        Course existing = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id=" + id));
        existing.setName(courseDTO.getName());
        existing.setDescription(courseDTO.getDescription());
        existing.setUpdatedAt(LocalDateTime.now());
        return courseMapper.toDto(courseRepository.save(existing));
    }

    @Override
    public void deleteCourse(Long id) {
        log.warn("Deleting course with id {}", id);
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Course not found with id=" + id);
        }
        courseRepository.deleteById(id);
    }
}
