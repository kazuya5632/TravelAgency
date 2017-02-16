package dao;

import java.util.List;

import beans.Tour;

public interface TourDAO {
	// ツアー登録
	abstract void registTour(Tour tour);

	// コースコード検索
	abstract List<Tour> findTourByCourseCode(int courseCode, String departure);

	// 主キー検索
	abstract Tour findTourByPrimaryKey(int code);
}
