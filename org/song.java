package org;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class song {

	private static Sequence[] songs = new Sequence[2];
	private static Sequencer sequencer;

	public song() {

		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			// songs[0] =
			// MidiSystem.getSequence(ResourcesManager.class.getResourceAsStream(PREFIX+"/mus/smb3map1.mid"));
			// songs[1] =
			// MidiSystem.getSequence(ResourcesManager.class.getResourceAsStream(PREFIX+"/mus/smwovr1.mid"));
			// songs[2] =
			// MidiSystem.getSequence(ResourcesManager.class.getResourceAsStream(PREFIX+"/mus/smb3undr.mid"));
			// songs[3] =
			// MidiSystem.getSequence(ResourcesManager.class.getResourceAsStream(PREFIX+"/mus/smwfortress.mid"));
			// songs[4] =
			// MidiSystem.getSequence(ResourcesManager.class.getResourceAsStream(PREFIX+"/mus/smwtitle.mid"));
		} catch (Exception e) {
			sequencer = null;
			e.printStackTrace();
		}

	}
}
