import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import javax.sound.sampled.*;
import javax.sound.sampled.spi.AudioFileReader;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {MainMenu menu = new MainMenu();
//        Scanner scanner = new Scanner(System.in);
//        File file = new File("C:\\Users\\90533\\Desktop\\SwordOfRevenge\\Müzikler\\Spikeroog.wav");
//        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
//        Clip clip = AudioSystem.getClip();
//        clip.open(audioStream);
//        clip.loop(Clip.LOOP_CONTINUOUSLY);
        String[] musicList = {
                "C:\\Users\\90533\\Desktop\\SwordOfRevenge\\Müzikler\\Bear-McCreary-Huldra-Brothers-God-of-War-Ragnarök-_Original-Soundtrack_.wav",
                "C:\\Users\\90533\\Desktop\\SwordOfRevenge\\Müzikler\\Spikeroog.wav",
                // Diğer müzik dosyalarının yolları...
        };
        MusicPlayer player = new MusicPlayer(musicList);
        player.playMusic();
        while(true){
            menu.showMenu();
        }
    }
}




