package test.UI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakeFrame extends JFrame implements ActionListener{

    JMenuBar jMenuBar = new JMenuBar();

    JMenu function = new JMenu("功能");
    JMenu about = new JMenu("关于");

    JMenuItem replay = new JMenuItem("重新游戏");
    JMenuItem Return = new JMenuItem("返回");


    public SnakeFrame(){

        initSnakeFrame();

        initMenu();
    }

    public void initMenu() {


        function.add(replay);
        function.add(Return);

        jMenuBar.add(function);
        jMenuBar.add(about);

        Return.addActionListener(this);
        replay.addActionListener(this);

        this.setJMenuBar(jMenuBar);



    }

    private void initSnakeFrame() {
        this.getContentPane().removeAll();

        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setTitle("贪吃蛇");
        this.setBounds((width-800)/2,(height-800)/2,805 ,820);

        SnakePanel gp = new SnakePanel();
        this.getContentPane().add(gp);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);

        this.getContentPane().repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == Return){
            this.setVisible(false);
            new Gamejframe();
        }
        else if(obj == replay){
            this.setVisible(false);
            new SnakeFrame();
        }
    }
}
