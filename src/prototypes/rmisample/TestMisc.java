package prototypes.rmisample;

import java.util.ArrayList;

import com.umbrella.worldconq.domain.GameListModel;

import domain.GameInfo;

public class TestMisc {

	public static void main(String[] args) {
		final GameListModel m = new GameListModel();
		final ArrayList<GameInfo> l = new ArrayList<GameInfo>();
		l.add(new GameInfo());
		m.setData(l);
		System.out.println(m.getValueAt(5, 90));
	}
}
