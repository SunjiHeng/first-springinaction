package springinaction.sound.system;

import org.springframework.stereotype.Component;

@Component
public class MediaPlayer implements CompactDisc {
    @Override
    public void play() {
        System.out.println (MediaPlayer.class);
    }
}
