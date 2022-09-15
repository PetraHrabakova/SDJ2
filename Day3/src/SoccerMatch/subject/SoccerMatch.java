package SoccerMatch.subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SoccerMatch implements PropertyChangeSubject {

	private PropertyChangeSupport propertyChangeSupport;
	private String team0 = "Dream Team";
	private String team1 = "Old Boys";
	private int currentTeam;
	private int previousTeam;


	public SoccerMatch() {
		propertyChangeSupport = new PropertyChangeSupport(this);
	}

	public void start() throws InterruptedException {
		System.out.println("Match starting \n\n");
		Random random = new Random();
		for (int i = 0; i < 90; i++) {

			int rand = random.nextInt(100);
			int whichTeam = random.nextInt(2);

			if (rand < 8) {
				// score goal
				scoreGoal(whichTeam);
				currentTeam = whichTeam;
			} else if (rand < 12) {
				// penalty
				roughTackle(whichTeam);
				currentTeam = whichTeam;
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				break;
			}
		}
		
		System.out.println("\n\nMatch ended");
	}

	private void roughTackle(int whichTeam) {
		if (whichTeam == 0) {
			// TODO team0 made a rough tackle
			System.out.println("Dream Team tackled roughly");
			propertyChangeSupport.firePropertyChange("DreamTeamRoughTackle", team1, "DreamTeamRoughTackle");
		} else {
			// TODO team1 made a rough tackle
			System.out.println("Old Boys tackled roughly");
			propertyChangeSupport.firePropertyChange("OldBoysRoughTackle", team0, "OldBoysRoughTackle");
		}
	}

	private void scoreGoal(int whichTeam) {
		if(whichTeam == 0) {
			// TODO team0 scored
			System.out.println("Dream Team scored");
			propertyChangeSupport.firePropertyChange("DreamTeamScore", team1, "DreamTeamScore");
		} else {
			// TODO team1 scored
			System.out.println("Old boys scored");
			propertyChangeSupport.firePropertyChange("OldBoysScore", team0, "OldBoysScore");
		}
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

}
