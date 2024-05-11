package test.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


public class SnakePanel extends JPanel {
    //蛇的长度
    int length;
    int length2;
    //蛇身的x坐标
    int[] snakeX = new int[300];

    //蛇身的y坐标
    int[] snakeY = new int[300];

    boolean isStart = false;//默认游戏暂停

    boolean isDead = false;

    Timer timer;
    //定义蛇的行走方向
    String direction;

    int foodX;
    int foodY;

    int score;

    public void init(){
        //初始蛇的长度
        length = 3;
        length2 = 3;
        //初始蛇头坐标
        snakeX[0] = 175;
        snakeY[0] = 275;
        //初始第一节蛇身坐标
        snakeX[1] = 150;
        snakeY[1] = 275;
        //初始第二节蛇身坐标
        snakeX[2] = 125;
        snakeY[2] = 275;
        //初始蛇头方向
        direction = "R";//R:右 L:左 U:上 D:下

        foodX = 300;
        foodY = 200;


    }
    public SnakePanel(){
        init();
        //将焦点定位在当前操作的面板上
        this.setFocusable(true);
        //加入监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_SPACE){
                    if(isDead){
                        init();
                        isDead = false;
                    }
                    else {
                        isStart = !isStart;
                        repaint();//重绘
                    }
                }
                //蛇1监听向上
                if(keyCode == KeyEvent.VK_UP){
                    direction = "U";
                }
                //蛇1监听向下
                if(keyCode == KeyEvent.VK_DOWN){
                    direction = "D";
                }
                //蛇1监听向左
                if(keyCode == KeyEvent.VK_LEFT){
                    direction = "L";
                }
                //蛇1监听向右
                if(keyCode == KeyEvent.VK_RIGHT){
                    direction = "R";
                }

            }
        });
        //对定时器进行初始化
        timer = new Timer(100, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isStart && !isDead){//游戏是开始状态才动
                    //后一节身子走到前一节身子的位置上
                    for(int i=length-1; i>0; i--){
                        snakeX[i] = snakeX[i-1];
                        snakeY[i] = snakeY[i-1];
                    }

                    //动头
                    if("R".equals(direction)){
                        snakeX[0] +=25;
                    }

                    if("L".equals(direction)){
                        snakeX[0] -=25;
                    }

                    if("U".equals(direction)){
                        snakeY[0] -=25;
                    }

                    if("D".equals(direction)){
                        snakeY[0] +=25;
                    }

                    if(snakeX[0]>750){
                        snakeX[0] = 25;
                    }

                    if(snakeX[0]<20){
                        snakeX[0] = 750;
                    }

                    if(snakeY[0]<60){
                        snakeY[0] = 725;
                    }

                    if(snakeY[0]>725){
                        snakeY[0] = 100;
                    }

                    //检查碰撞
                    if(snakeX[0] == foodX && snakeY[0] == foodY){
                        length++;
                        //随机生存食物坐标
                        foodX = ((int)(Math.random()*30)+1)*25;//[25,750]
                        foodY = (new Random().nextInt(26)+4)*25;//[100,725]
                        Gamejframe.step+=10;
                        SoundPool soundPool = new SoundPool("D:\\桌面\\测试\\untitled\\src\\music\\muyu.wav");
                        soundPool.start();
                    }

                    for(int i = 1;i<length;i++){
                        if(snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]){
                            isDead = true;
                        }
                    }
                    repaint();//重绘
                }
            }
        });
        //启动定时器
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(0xDA5B5B));
        image.headerImg.paintIcon(this,g,10,10);
        g.setColor(new Color(219,226,219));
        g.fillRect(10,70,770,685);

        //画蛇头
        if("R".equals(direction)) {
            image.rightImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        if("L".equals(direction)) {
            image.leftImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        if("U".equals(direction)) {
            image.upImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        if("D".equals(direction)) {
            image.downImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }


        //画蛇身
        for (int i = 1;i<length;i++){
            image.bodyImg.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        if(!isStart){
            g.setColor(new Color(0x4678EB));
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("点击空格开始游戏",250,330);
        }

        //画食物
        image.foodImg.paintIcon(this,g,foodX,foodY);

        g.setColor(new Color(0xE8C825));
        g.setFont(new Font("正楷",Font.BOLD,20));
        g.drawString("功德："+Gamejframe.step,50,45);

        if(isDead){
            g.setColor(new Color(0xE8C825));
            g.setFont(new Font("正楷",Font.BOLD,40));
            g.drawString("你失败了，功德扣100!",220,330);
            Gamejframe.step-=100;
            SoundPool soundPool = new SoundPool("D:\\桌面\\测试\\untitled\\src\\music\\fozuxiao.wav");
            soundPool.start();
        }
    }
}
