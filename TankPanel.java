import javax.swing.*;
import java.awt.*;

class TankPanel extends JPanel {
    private TankMain tank;

    public TankPanel(TankMain tank) {
        this.tank = tank;
    }

    public void setTank(TankMain newTank) {
        this.tank = newTank;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int panelHeight = getHeight();
        int panelWidth = getWidth();
              
        // background water
        g2d.setColor(new Color(126, 194, 213));
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // sand at the bottom
        int yBottom = panelHeight - tank.SAND_HEIGHT;
        g2d.setColor(new Color(194, 178, 128));
        g2d.fillRect(0, yBottom, getWidth(), tank.SAND_HEIGHT);

        // algae bloom
        double algaeLevel = tank.getAlgae().getLevel();
        double opacity = algaeLevel / 100.0;

        if (opacity > 1.0) opacity = 1.0;
        if (opacity < 0.0) opacity = 0.0;

        int alpha = (int)(opacity * 200);
        Color algaeColor = new Color(0, 128, 0, alpha);
        g2d.setColor(algaeColor);

        // Fill the top water area with algae
        g2d.fillRect(0, 0, panelWidth, yBottom);

        // draw the fish
        for (Fish f : tank.getFish()) {
            if (!f.isAlive()) {
                g2d.setColor(Color.DARK_GRAY);
                g2d.fillOval(f.getX(), f.getY(), 50, 20);
            }
            else {
               int height = 30;
                g2d.setColor(f.getColor());
                if(f.isHungry()) {
                  height = 20;
                }
                g2d.fillOval(f.getX(), f.getY(), 50, height);
            }
        }

        // draw the cleaners
        for (Cleaner c : tank.getCleaners()) {
            if (!c.isAlive()) {
                g2d.setColor(Color.DARK_GRAY);
            } else {
                g2d.setColor(c.getColor());
            }
            g2d.fillRect(c.getX(), c.getY(), 30, 30);
        }

        // draw the plants
        for (Plant p : tank.getPlants()) {
          if (p.getPlantType().equals("Java Fern")) {
              g2d.setColor(new Color(39, 138, 37)); // dark green
              g2d.setStroke(new BasicStroke(4));
              int plantTop = yBottom - p.getSize() * 5;
              g2d.drawLine(p.getX(), yBottom, p.getX(), plantTop);
  
          } else if (p.getPlantType().equals("Water Weed")) {
              g2d.setColor(new Color(67, 196, 75)); // lighter green
              g2d.setStroke(new BasicStroke(1));
              int plantTop = yBottom - p.getSize() * 15;
               g2d.drawLine(p.getX(), yBottom, p.getX() - 5, plantTop);
               g2d.drawLine(p.getX(), yBottom, p.getX(), plantTop);
               g2d.drawLine(p.getX(), yBottom, p.getX() + 5, plantTop);
  
          } else if (p.getPlantType().equals("Lily Pad")) {
               g2d.setColor(new Color(69, 168, 97));
               int size = p.getSize() * 3;
               g2d.fillOval(p.getX(), p.getY(), size, size);
            }  
         }
    }
}


