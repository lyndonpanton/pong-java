package manager;

import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import java.io.File;


public class SoundManager {
    private final static String sfxPath = "audio/ultimate-ui-sfx-pack/wav-sd/";

    // note: having too many clips open may cause
    // "LineUnavailableException: No Free Voices"
    public final static Clip[] bullets = new Clip[14];

    public final static Clip cancel1 = getClip("cancel-1");
    public final static Clip cancel2 = getClip("cancel-2");
    public final static Clip cursor1 = getClip("cursor-1");
    public final static Clip cursor2 = getClip("cursor-2");
    public final static Clip cursor3 = getClip("cursor-3");
    public final static Clip cursor4 = getClip("cursor-4");
    public final static Clip cursor5 = getClip("cursor-5");
    public final static Clip error1 = getClip("error-1");
    public final static Clip popupClose1 = getClip("popup-close-1");
    public final static Clip popupOpen1 = getClip("popup-open-1");
    public final static Clip select1 = getClip("select-1");
    public final static Clip select2 = getClip("select-2");
    public final static Clip swipe1 = getClip("swipe-1");
    public final static Clip swipe2 = getClip("swipe-2");

    public final static Clip[] clips = {
            cancel1,
            cancel2,
            cursor1,
            cursor2,
            cursor3,
            cursor4,
            cursor5,
            error1,
            popupClose1,
            popupOpen1,
            select1,
            select2,
            swipe1,
            swipe2
    };

    public static void main(String[] args) throws Exception {
        for (Clip clip: clips) {
            play(clip);
            Thread.sleep(1000);
        }
    }

    public static void play(Clip clip) {
        clip.setFramePosition(0);
        clip.start();
    }

    private static Clip getClip(String filename) {
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            AudioInputStream sample = AudioSystem.getAudioInputStream(new File(
                    sfxPath + filename + ".wav"));
            clip.open(sample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clip;
    }


    // Game start
    // Game end
        // Player one wins
        // Player two wins
    // Ball bounce
        // Player one ball bounce
        // Player two ball bounce
}
