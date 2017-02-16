package logic;

import java.util.List;

import beans.Course;

public interface CourseLogicInterface {

	// コース登録
	void registCourse(Course course);

	// 全件検索
	List<Course> searchAll();

	// 主キー検索
	Course findCourseByPrimaryKey(int code);
}