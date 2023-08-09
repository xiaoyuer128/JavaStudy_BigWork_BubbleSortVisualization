package BubbleSort;

import java.awt.BorderLayout;
//window容器默认布局
import java.awt.Color;
//颜色封装，默认RGB颜色
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JList;
//可选取对象列表
import javax.swing.JPanel;
import javax.swing.JScrollPane;
//右侧滚动面板
import javax.swing.Timer;

public class BSPanel extends JPanel {


    private static final String[] BUBBLE_SOURCE_CODE = {
            "public void bubbleSort(int[] data) {       ",
            "  for (int i = 0; i < data.length - 1; i++) {",
            "    for (int j = 0; j < data.length - i - 1; j++) {",
            "      if (data[j] > data[j + 1]) {          ",
            "        int temp = data[j + 1];         ",
            "        data[j + 1] = data[j];           ",
            "        data[j] = temp;             ",
            "      }                              ",
            "    }                                ",
            "  }                                  ",
            "}                                    " };

    private JList<String> codeList = new JList<String>(BUBBLE_SOURCE_CODE);

    /*
     * 初始化10个数据
     */
    private List<NumberRectangle> numbers = initialNumberRectangles();


    public TimerAction timerAction;

    public Timer timer;

    public BSFrame frame;

    public BSPanel(BSFrame frame) {

        timerAction = new TimerAction();
        timer = new Timer(1000, timerAction);

        codeList.setSelectedIndex(1);
        //高亮显示指定的行
        JScrollPane scrollPane1 = new JScrollPane(codeList);
        this.setLayout(new BorderLayout());
        this.add(scrollPane1, BorderLayout.EAST);

        this.setBackground(Color.yellow);
        this.frame = frame;
    }

    /*
     * 判断排序是否已经结束
     */
    private boolean completed = false;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        drawNumberRectangles(g2);
    }

    private void drawNumberRectangles(Graphics2D g2) {
        for (NumberRectangle rectangle : numbers) {
            rectangle.draw(g2);
        }
    }

    int out = 0;
    int in = 0;
    int sIndex = 1;

    private class TimerAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (completed) {
                return;
            }

            switch (sIndex) {
                case 1:
                    if (out < 10)
                    {
                        in = 0;
                        codeList.setSelectedIndex(sIndex++);
                    }
                    else
                    {
                        sIndex = 10;
                    }
                    break;
                case 2:
                    if (in < 10 - out - 1)
                    {
                        numbers.get(in).setColor(Color.red);
                        numbers.get(in + 1).setColor(Color.red);
                        codeList.setSelectedIndex(sIndex++);
                    }
                    else
                    {
                        out++;
                        sIndex = 1;
                    }
                    break;
                case 3:
                    if (numbers.get(in).getValue() > numbers.get(
                            in + 1).getValue())
                    {
                        codeList.setSelectedIndex(sIndex++);
                    }
                    else
                    {
                        numbers.get(in + 1).setColor(Color.green);
                        numbers.get(in).setColor(Color.green);
                        in++;
                        sIndex = 2;
                    }
                    break;
                case 4:
                    codeList.setSelectedIndex(sIndex++);
                    break;
                case 5:
                    codeList.setSelectedIndex(sIndex++);
                    break;

                case 6:
                    codeList.setSelectedIndex(sIndex);
                    int tempValue1 = numbers.get(in).getValue();
                    int tempValue2 = numbers.get(in + 1).getValue();

                    numbers.get(in + 1).setValue(tempValue1);
                    numbers.get(in).setValue(tempValue2);
                    numbers.get(in + 1).setColor(Color.GREEN);
                    numbers.get(in).setColor(Color.GREEN);

                    sIndex = 2;
                    in++;
                    break;

                case 10:
                    if (sIndex == 10)
                    {
                        completed = true;
                        codeList.setSelectedIndex(sIndex);
                    }
                    break;
                default:
                    break;
            }

            repaint();

        }
    }

    private List<NumberRectangle> initialNumberRectangles()
    {
        List<NumberRectangle> list = new ArrayList<NumberRectangle>();


        /*
          随机产生10个数组
         */
        Random random = new Random();

        for (int i = 1; i <= 10; i++)
        {
            list.add(new NumberRectangle(i, 1, random.nextInt(15) + 1,
                    Color.green));
        }
        return list;
    }

}
