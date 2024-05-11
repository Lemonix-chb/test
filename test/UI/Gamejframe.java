package test.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Gamejframe extends JFrame implements ActionListener, MouseListener {

    JMenuItem replay = new JMenuItem("重新游戏");
    JMenuItem relogin = new JMenuItem("重新登录");
    JMenuItem closegame = new JMenuItem("关闭游戏");

    JMenuItem chongzhi = new JMenuItem("充值入口");
    JMenuItem aboutme = new JMenuItem("关于我们");
    JMenuItem Snake = new JMenuItem("贪吃蛇");

    JLabel jLabel1 = new JLabel(new ImageIcon("D:\\桌面\\测试\\untitled\\src\\image\\R.png"));
    JButton jButton = new JButton(new ImageIcon("D:\\桌面\\测试\\untitled\\src\\image\\1.png"));


    public static int step=0;

    JLabel setcout = new JLabel("功德: "+step);

    JButton fozuxiao = new JButton("扣1佛祖陪你笑");

    public Gamejframe(){


        initJframe();


        initJmenuBar();


        this.setLayout(null);
        //界面可视
        this.setVisible(true);

    }

    public void initJmenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu function = new JMenu("功能");
        JMenu about = new JMenu("关于");


        replay.addActionListener(this);
        relogin.addActionListener(this);
        closegame.addActionListener(this);
        chongzhi.addActionListener(this);
        aboutme.addActionListener(this);
        Snake.addActionListener(this);

        function.add(replay);
        function.add(relogin);
        function.add(closegame);
        function.add(Snake);

        about.add(chongzhi);
        about.add(aboutme);

        jMenuBar.add(function);
        jMenuBar.add(about);

        fozuxiao.setBounds(390,20,125,30);
        this.getContentPane().add(fozuxiao);
        fozuxiao.addMouseListener(this);
        fozuxiao.setBorderPainted(false);
        fozuxiao.setFocusPainted(false);

        this.setJMenuBar(jMenuBar);


    }

    private void initJframe() {

        this.getContentPane().removeAll();


        setcout.setBounds(100,50,200,150);
        Font font = new Font("正楷",Font.PLAIN,30);
        setcout.setFont(font);
        setcout.setForeground(new Color(0xDDDD1C));
        this.getContentPane().add(setcout);


        this.setSize(900,650);
        this.setTitle("功德平台 1.0");
        //界面置顶
        this.setAlwaysOnTop(true);
        //界面居中
        this.setLocationRelativeTo(null);
        //界面关闭
        this.setDefaultCloseOperation(3);


        jLabel1.setBounds(250,330,260,180);
        this.getContentPane().add(jLabel1);


        jButton.setBounds(380,420,150,107);
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



        this.getContentPane().repaint();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == chongzhi){
            System.out.println("充值人口");
            JDialog jDialog = new JDialog();
            jDialog.setTitle("充值人口");
            JLabel jLabel = new JLabel(new ImageIcon("D:\\桌面\\测试\\untitled\\src\\image\\微信图片_20240425191728.jpg"));
            jLabel.setBounds(0,0,300,300);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(350,350);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }
        else if(obj == replay){
            System.out.println("重新开始");
            this.setVisible(false);
            new zuichuframe();
        }
        else if(obj == relogin){
            System.out.println("登陆界面");
            this.setVisible(false);
            new Loginframe();
        }
        else if(obj == closegame){
            System.out.println("退出游戏");
            System.exit(0);
        }
        else if(obj == aboutme){
            JDialog jDialog = new JDialog();
            jDialog.setTitle("关于我们");
            JLabel jLabel = new JLabel(new ImageIcon("D:\\桌面\\测试\\untitled\\src\\image\\微信图片_20240425191742.jpg"));
            jLabel.setBounds(0,0,300,300);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(350,350);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }
        else if(obj == Snake){
            System.out.println("贪吃蛇");
            this.setVisible(false);
            new SnakeFrame();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(jButton == e.getSource()){
            SoundPool soundPool = new SoundPool("D:\\桌面\\测试\\untitled\\src\\music\\muyu.wav");
            soundPool.start();
            step++;
            System.out.println("功德加一"+step);
            //initJframe();
            setcout.setText("功德: "+step);

        }
        if(fozuxiao == e.getSource()){
            SoundPool soundPool = new SoundPool("D:\\桌面\\测试\\untitled\\src\\music\\fozuxiao.wav");
            soundPool.start();
            step-=10;
            setcout.setText("功德: "+step);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(jButton == e.getSource()){
            jLabel1.setIcon(new ImageIcon("D:\\桌面\\测试\\untitled\\src\\image\\2.png"));

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(jButton == e.getSource()){
            jLabel1.setIcon(new ImageIcon("D:\\桌面\\测试\\untitled\\src\\image\\R.png"));
            
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
