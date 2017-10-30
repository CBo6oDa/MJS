import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Painting {
    static List<int[]> list = new ArrayList<int[]>();
    static MJS obj= new MJS();
    static int[] arrayU;
    static int[] arrayV;

    public static void main(String[] a) {
        list=obj.process();
        arrayU=list.get(0);
        arrayV=list.get(1);

        MyJFrame f = new MyJFrame();
        f.setTitle("Drawing");
        f.setBounds(0,0,2000,2000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    static class MyJFrame extends JFrame {
        MJS obj = new MJS();
        public void paint(Graphics g) {
            GeneralPath axes = new GeneralPath(GeneralPath.WIND_EVEN_ODD,20);
            axes.moveTo((getSize().width/2),(getSize().height/2)+500);
            axes.lineTo((getSize().width/2),(getSize().height/2)-500);
            axes.moveTo((getSize().width/2)-700,(getSize().height/2));
            axes.lineTo((getSize().width/2)+700,(getSize().height/2));

            double x = -50;
            Point aPoint = new Point((int) ((getSize().width/2) + x), (int)((getSize().height/2) + (obj.getRezultV(
                    (Double)x/85.)+obj.getRezultU((Double)x/85.))*85));
            Polygon poly = new Polygon(arrayU, arrayV, arrayU.length);

            if(poly.contains(aPoint)) {
                g.setColor(new Color(0,0,0));
                ((Graphics2D)g).draw(axes);
                g.setColor(new Color(100,2,25));
                g.fillPolygon(poly);
                g.setColor(new Color(0,255,0));
                //g.drawString("YES", aPoint.x, aPoint.y);
            }
            else{
                g.setColor(new Color(100,2,25));
                g.fillRect(0,0,getWidth(),getHeight());
                g.setColor(new Color(0,0,0));
                ((Graphics2D)g).draw(axes);
                g.setColor(new Color(255,255,255));
                g.fillPolygon(poly);
                g.setColor(new Color(0,0,0));
                g.drawPolygon(poly);
                g.setColor(new Color(255,0,0));
                //g.drawString("NO", aPoint.x, aPoint.y);
            }
        }
    }
}