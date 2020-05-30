package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.StudentVo;

public interface StudentService {
	List<StudentVo> getStudentList(StudentVo searchVo);
}
