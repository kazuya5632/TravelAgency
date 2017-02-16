package logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import beans.Participant;
import dao.DaoFactory;
import dao.ParticipantDAO;

public class ParticipantLogic implements ParticipantLogicInterface {
	// データアクセスオブジェクト生成
	private ParticipantDAO dao = DaoFactory.createParticipantDAO();

	@Override
	public int registParticipant(Participant participant, String adultNumber, int adultPrice, String childNumber,
			int childPrice, String departure) {
		int orderMoney = 0;
		try {

			// 参加者（責任者）登録
			dao.registParticipant(participant);

			// 申込金計算
			orderMoney = orderMoneyCalc(adultNumber, adultPrice, childNumber, childPrice, departure);

			return orderMoney;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 出発日と申し込み日の差分を計算
	 * @param departure
	 * @return dayDiff 差分の日付
	 */
	public long dayCalc(String departure) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
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

	/**
	 * 申込金を計算
	 * @param adultNumber
	 * @param adultPrice
	 * @param childNumber
	 * @param childPrice
	 * @param departure
	 * @return orderMoney 申込金
	 */
	public int orderMoneyCalc(String adultNumber, int adultPrice, String childNumber, int childPrice,
			String departure) {
		int orderMoney = 0;
		long dayDiff = 0;
		int money = 0;
		// 差分の日付 = 出発日 - 申し込み日
		dayDiff = dayCalc(departure);

		// 金額
		int adNumber = Integer.parseInt(adultNumber);
		int chNumber = Integer.parseInt(childNumber);
		money = (adNumber * adultPrice) + (chNumber * childPrice);

		// 申込金計算
		if (dayDiff >= 60) {
			// 差分の日付が60日以上の場合
			orderMoney = (int) (money * 0.1);
		} else if ((dayDiff >= 30) && (dayDiff < 60)) {
			orderMoney = (int) (money * 0.2);
		} else if (dayDiff < 30) {
			orderMoney = (int) money;
		}

		return orderMoney;
	}
}
