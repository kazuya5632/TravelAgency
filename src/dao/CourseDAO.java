package dao;

import java.util.List;

import beans.Course;

public interface CourseDAO {

	// コース登録
	abstract void registCourse(Course course);

	// 全件検索
	abstract List<Course> searchAll();

	// 主キー検索
	abstract Course findCourseByPrimaryKey(int code);
}
