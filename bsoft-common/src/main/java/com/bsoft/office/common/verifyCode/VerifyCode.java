package com.bsoft.office.common.verifyCode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 随机验证码
 */
public class VerifyCode {
    private static final char[] CHARS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    // 字符数量
    private static final int SIZE = 4;
    private static Random random = new Random();
    private static String text; //用来保存验证码的文本内容

    //获取验证码
    private static String getCode(int length){
        StringBuffer sb = new StringBuffer();
        int rnd;
        for(int i=0;i<length;i++){
            rnd = Math.abs(random.nextInt()) % CHARS.length;
            sb.append(CHARS[rnd]);
        }
        return sb.toString();
    }

    //获取随机颜色
    private static Color getRandColor(int fc,int bc){
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    public static BufferedImage createImage(){

        int width = 34 * SIZE;
        int height = 40;

        //创建图片缓冲区
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        //获取画笔
        Graphics g = image.getGraphics();
        Random random = new Random();
        //设置背景色随机
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        //
        g.setColor(getRandColor(160, 200));
        //画干扰线
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(34);
            int yl = random.nextInt(34);
            g.drawLine(x, y, x + xl, y + yl);
        }
        String sCode = getCode(SIZE);
        text = sCode;
        for (int i = 0; i < SIZE; i++) {
            String rand = sCode.substring(i, i + 1);
            g.setColor(new Color(20 + random.nextInt(60), 20 + random
                    .nextInt(120), 20 + random.nextInt(180)));
            //定义字符的x坐标
            g.drawString(rand, 33 * i + 6, 26);
        }
        g.dispose();
        return image;
    }

    public static String getText(){
        return text;
    }

    //将验证码图片写出的方法
    public static void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image, "JPEG", out);
    }
}
