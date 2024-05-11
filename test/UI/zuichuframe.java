package test.UI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class zuichuframe extends JFrame implements MouseListener {

    JButton jButton = new JButton(new ImageIcon("D:\\桌面\\测试\\untitled\\src\\image\\微信截图_20240426194705.png"));

    public  zuichuframe() {
        this.setSize(900,640);
        this.setTitle("功德平台 1.0");
        //界面置顶
        this.setAlwaysOnTop(true);
        //界面居中
        this.setLocationRelativeTo(null);
        //界面关闭
        this.setDefaultCloseOperation(3);



        jButton.setBounds(400,500,125,45);
        this.getContentPane().add(jButton);
        jButton.addMouseListener(this);
        //去除焦点边框
        jButton.setFocusPainted(false);
        //去除按钮填充物
        jButton.setContentAreaFilled(false);
        //去除边框
        jButton.setBorderPainted(false);



        JLabel jLabel = new JLabel(new ImageIcon("D:\\桌面\\测试\\untitled\\src\\image\\bp.png"));
        jLabel.setBounds(0,0,900,600);
        this.getContentPane().add(jLabel);

        this.setLayout(null);
        //界面可视
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(jButton == e.getSource()){
            SoundPool soundPool = new SoundPool("D:\\桌面\\测试\\untitled\\src\\music\\muyu.wav");
            soundPool.start();
            this.setVisible(false);
            Gamejframe G = new Gamejframe();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (jButton == e.getSource()) {
            System.out.println("鼠标进入");
            jButton.setIcon(new ImageIcon("D:\\桌面\\测试\\untitled\\src\\image\\微信截图_20240426194645.png"));

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("鼠标离开");
        jButton.setIcon(new ImageIcon("D:\\桌面\\测试\\untitled\\src\\image\\微信截图_20240426194705.png"));
    }
}
