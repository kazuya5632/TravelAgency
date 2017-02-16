package logic;

import java.util.List;

import beans.Course;
import dao.CourseDAO;
import dao.DaoFactory;

public class CourseLogic implements CourseLogicInterface {
	// データアクセスオブジェクト生成
	private CourseDAO dao = DaoFactory.createCourseDAO();

	// コース登録
	/* (非 Javadoc)
	 * @see logic.CourseLogicInterface#registCourse(beans.Course)
	 */
	@Override
	public void registCourse(Course course) {
		dao.registCourse(course);
	}

	// コース全件検索
	@Override
	public List<Course> searchAll() {
		return dao.searchAll();
	}

	// 主キー検索
	@Override
	public Course findCourseByPrimaryKey(int code) {
		return dao.findCourseByPrimaryKey(code);
	}
}
