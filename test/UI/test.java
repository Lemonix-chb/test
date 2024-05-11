package test.UI;



public class test {
    public static void main(String[] args) {

        zuichuframe Z = new zuichuframe();
        String f = "D:\\桌面\\测试\\untitled\\src\\music\\dabeizou.wav";
        SoundPool soundPool = new SoundPool(f);
        soundPool.start();

    }
}
