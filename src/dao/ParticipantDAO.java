package dao;

import beans.Participant;

public interface ParticipantDAO {
	// 参加者登録
	abstract void registParticipant(Participant participant);
}
