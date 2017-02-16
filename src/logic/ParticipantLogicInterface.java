package logic;

import beans.Participant;

public interface ParticipantLogicInterface {
	// 責任者登録
	int registParticipant(Participant participant, String adultNumber, int adultPrice, String childNumber,
			int childPrice, String departure);
}
