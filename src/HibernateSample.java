import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class HibernateSample {
	public static void main(String[] args) throws ParseException {

//		Date now = new Date(); // 申し込み日
//		Date truncDay = DateUtils.truncate(now, Calendar.DAY_OF_MONTH);
//
//		String certainDay = "2014-06-18"; // 比較対象2
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date cdDate = sdf.parse(certainDay);
//
//		System.out.println(truncDay);
//		System.out.println(cdDate);

		System.out.println(calc());




		/**
		 * Hibernate テスト
		 */
		// Configuration config = new Configuration().configure();
		// SessionFactory sessionFactory = config.buildSessionFactory();
		// Session session = sessionFactory.openSession();
		//

		// List<Tour> list = session.createCriteria(Tour.class).list();
		// for (Tour tour11 : list) {
		// System.out.println(tour11.getName());
		// }

		// Tour tour = (Tour) session.load(Tour.class, 1);
		// System.out.println("name : " + tour.getName());

		// Course course = (Course) session.load(Course.class, 1);
		//
		// System.out.println("name : " + course.getName());
		// session.close();
		//
		// System.out.println("OK");
		//
		// Item item1 = (Item) session.load(Item.class, 10);
		// System.out.println("name : " + item1.getName());
		//
		// Transaction transaction1 = session.beginTransaction();
		// item.setName("ドラゴンボール");
		// item.setPrice(30000);
		// session.update(item);
		// session.delete(item);
		// transaction1.commit();
		//
		// List<Item> list = session.createCriteria(Item.class).list();
		// for (Item item11 : list) {
		// System.out.println(item11.getName());
		// }
		//
		// System.out.println();
		//
		// Query query = session.createQuery("from beans.Item as item where
		// item.category_code = :categoryNo");
		// query.setInteger("categoryNo", 2);
		// List<Item> list2 = query.list();
		// for (Item item11 : list2) {
		// System.out.println(item11.getName());
		// }
		//
		// System.out.println();
		//
		// Query query2 = session.getNamedQuery("itemInCategory");
		// query.setInteger("categoryNo", 2);
		// List<Item> list3 = query.list();
		// for (Item item11 : list3) {
		// System.out.println(item11.getName());
		// }
		//
	}



/**
 * 2つの日付の差分日数を算出するプログラムです。
 * @param args
 */
	public static long calc() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String departure = "2017/05/01"; // 出発日
		Date dateTo = null;

		Date now = new Date(); // 申し込み日
		Date orderDay = DateUtils.truncate(now, Calendar.DAY_OF_MONTH);

		// 日付を作成
		try {
			dateTo = sdf.parse(departure);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 日付をlong値に変換
		long dateTimeTo = dateTo.getTime();
		long dateTimeFrom = orderDay.getTime();

		// 差分の日数を算出
		long dayDiff = (dateTimeTo - dateTimeFrom) / (1000 * 60 * 60 * 24);

		return dayDiff;
	}
}