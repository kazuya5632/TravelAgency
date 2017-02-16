package logic;

import java.util.List;

import beans.Tour;
import dao.DaoFactory;
import dao.TourDAO;

public class TourLogic implements TourLogicInterface {
	private TourDAO dao = DaoFactory.createTourDAO();

	@Override
	public void registTour(Tour tour) {
		dao.registTour(tour);
	}

	@Override
	public List<Tour> findTourByCourseCode(int courseCode, String departure) {
		return dao.findTourByCourseCode(courseCode,departure);
	}

	@Override
	public Tour findTourByPrimaryKey(int code) {
		return dao.findTourByPrimaryKey(code);
	}

}
