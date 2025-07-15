import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    JLabel question;
    JRadioButton opt1, opt2, opt3, opt4;
    JButton next;
    ButtonGroup options;
    int count = 0, score = 0;

    String[] questions = {
        "What is Java?",
        "Which company developed Java?"
    };

    String[][] optionsData = {
        {"Language", "IDE", "OS", "None"},
        {"Sun Microsystems", "Google", "Microsoft", "Apple"}
    };

    int[] correctAnswers = {0, 0}; // index of correct option

    public Quiz() {
        setTitle("Quiz");
        setSize(400, 300);
        setLayout(new GridLayout(6, 1));

        question = new JLabel();
        add(question);

        opt1 = new JRadioButton();
        opt2 = new JRadioButton();
        opt3 = new JRadioButton();
        opt4 = new JRadioButton();

        options = new ButtonGroup();
        options.add(opt1); options.add(opt2);
        options.add(opt3); options.add(opt4);

        add(opt1); add(opt2); add(opt3); add(opt4);

        next = new JButton("Next");
        next.addActionListener(this);
        add(next);

        loadQuestion();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void loadQuestion() {
        question.setText((count + 1) + ". " + questions[count]);
        opt1.setText(optionsData[count][0]);
        opt2.setText(optionsData[count][1]);
        opt3.setText(optionsData[count][2]);
        opt4.setText(optionsData[count][3]);
        options.clearSelection();
    }

    public void actionPerformed(ActionEvent e) {
        if (getSelectedOption() == correctAnswers[count]) score++;
        count++;
        if (count == questions.length) {
            new Result(score, questions.length);
            dispose();
        } else {
            loadQuestion();
        }
    }

    int getSelectedOption() {
        if (opt1.isSelected()) return 0;
        if (opt2.isSelected()) return 1;
        if (opt3.isSelected()) return 2;
        if (opt4.isSelected()) return 3;
        return -1;
    }
}
