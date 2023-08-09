package BubbleSort;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class NumberRectangle {

    private int x;

    private int y;

    private int value;

    private Color color;

    public NumberRectangle() {
    }

    public NumberRectangle(int x, int y, int value, Color color) {
        this.x = x;
        this.y = y;

        this.color = color;
        this.value = value;

    }

    public void draw(Graphics2D g2) {
        int clientX = 30 + x * 60;
        int clientY = 20 + y * 40;

        Rectangle2D.Double rect = new Rectangle2D.Double(clientX, clientY, 40,
                value * 30);//设置矩形大小颜色

        g2.setPaint(color);
        g2.fill(rect);
        g2.setPaint(Color.black);//设置字体颜色为黑色
        g2.draw(rect);
        g2.drawString(String.valueOf(value),clientX+10, clientY-20);//调整字体居中在矩形上
    }


    public Color getColor()
    {
        return color;
    }


    public void setColor(Color color)
    {
        this.color = color;
    }

    public int getX()
    {
        return x;
    }


    public void setX(int x)
    {
        this.x = x;
    }


    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }


    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

}