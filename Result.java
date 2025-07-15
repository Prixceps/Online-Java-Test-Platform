import javax.swing.*;
import java.awt.*;

public class Result extends JFrame {
    public Result(int score, int total) {
        setTitle("Result");
        setSize(300, 200);
        setLayout(new GridLayout(2, 1));
        add(new JLabel("Score: " + score + "/" + total, SwingConstants.CENTER));
        add(new JLabel(score >= total / 2 ? "Status: PASS" : "Status: FAIL", SwingConstants.CENTER));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
