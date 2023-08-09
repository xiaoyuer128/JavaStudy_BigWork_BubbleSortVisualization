package BubbleSort;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;//子菜单
import javax.swing.JRadioButtonMenuItem;//单项选择框

public class BSFrame extends JFrame {


    private Container contentPane;

    /*
    本类主要作用为
    设置三个Menu Item，分别用于开始程序，调整运行的速度以及退出程序
     */

    private JMenuItem start = new JMenuItem("Start");
    //开始菜单项

    private JMenu speedMenu = new JMenu("Speed");
//速度菜单

    private JMenuItem exit = new JMenuItem("Exit");
//结束菜单项


/*
设定5个速度级别
 */
    private JRadioButtonMenuItem speed1 = new JRadioButtonMenuItem("Speed1",
            true);
//单选按钮菜单项
    private JRadioButtonMenuItem speed2 = new JRadioButtonMenuItem("Speed2",
            false);

    private JRadioButtonMenuItem speed3 = new JRadioButtonMenuItem("Speed3",
            false);

    private JRadioButtonMenuItem speed4 = new JRadioButtonMenuItem("Speed4",
            false);

    private JRadioButtonMenuItem speed5 = new JRadioButtonMenuItem("Speed5",
            false);

    public int speedFlag = 1;

    /*
     冒泡排序可视化的Panel
     */

    private BSPanel panel;

    public BSFrame(){

        setTitle("可视化排序之冒泡排序");
        setSize(1000, 600);
        setResizable(false);//不可改变窗口大小

        setLocationRelativeTo(null);//设置居中

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu setMenu = new JMenu("Set");


        menuBar.add(setMenu);

        setMenu.add(start);
        setMenu.addSeparator();//添加分割线

        setMenu.addSeparator();
        setMenu.add(speedMenu);
        setMenu.addSeparator();
        setMenu.add(exit);

        ButtonGroup group = new ButtonGroup();//按钮组
        group.add(speed1);
        group.add(speed2);
        group.add(speed3);
        group.add(speed4);
        group.add(speed5);

/*
在speedMenu add speed按钮组
 */

        speedMenu.add(speed1);
        speedMenu.add(speed2);
        speedMenu.add(speed3);
        speedMenu.add(speed4);
        speedMenu.add(speed5);

/*
在各按钮中添加事件监听
 */

        start.addActionListener(new StartAction());
        speed1.addActionListener(new SpeedAction());
        speed2.addActionListener(new SpeedAction());
        speed3.addActionListener(new SpeedAction());
        speed4.addActionListener(new SpeedAction());
        speed5.addActionListener(new SpeedAction());
        exit.addActionListener(new ExitAction());

        contentPane = getContentPane();

/*
用getContentPane()方法获得JFrame的内容面板,再对其加入组件
 */

        panel = new BSPanel(this);
        contentPane.add(panel);
        start.setEnabled(true);
    }

    private class StartAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            start.setEnabled(false);

            panel.timer.start();
        }
    }

    private class ExitAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            System.exit(0);
        }
    }

    private class SpeedAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            Object speed = event.getSource();

            if (speed == speed1)
            {
                speedFlag = 1;
            } else if (speed == speed2)
            {
                speedFlag = 2;
            } else if (speed == speed3)
            {
                speedFlag = 3;
            } else if (speed == speed4)
            {
                speedFlag = 4;
            } else if (speed == speed5)
            {
                speedFlag = 5;
            }

            panel.timer.setDelay(1000 - 200 * (speedFlag - 1));
        }
    }

}