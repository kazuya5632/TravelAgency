package logic;

import java.util.List;

import beans.Tour;

public interface TourLogicInterface {
	// ツアー登録
	void registTour(Tour tour);

	// コースコード検索
	List<Tour> findTourByCourseCode(int courseCode, String departure);

	// 主キー検索
	Tour findTourByPrimaryKey(int code);
}
