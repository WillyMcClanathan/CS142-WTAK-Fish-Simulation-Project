import javax.swing.*;
import java.awt.*;

public class TankGUI extends JFrame {

   private TankMain tank;
   private JProgressBar wasteBar;
   private Timer timer;
   private TankPanel tankPanel;
   // constructor accepts TankMain and TankPanel objects
   public TankGUI() {
      tank = new TankMain();
      tankPanel = new TankPanel(tank);

      setTitle("Fish Tank Simulator");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      // Bar depicting the percentage of waste in the tank located at the top of the simulation
      wasteBar = new JProgressBar(0, 100);
      wasteBar.setStringPainted(true);
      add(wasteBar, BorderLayout.NORTH);
      // Drawing panel "simulation display"
      tankPanel = new TankPanel(tank);
      tankPanel.setPreferredSize(new Dimension(tank.TANK_WIDTH, tank.TANK_HEIGHT));
      add(tankPanel, BorderLayout.CENTER);
      // Buttons
      JPanel buttons = new JPanel();
      buttons.setBackground(new Color(194, 178, 128));

      JButton addFishBtn  = new JButton("Add Fish");
      JButton addSlowFishBtn  = new JButton("Add Slow Fish");
      JButton addCleanerBtn  = new JButton("Add Cleaner");
      buttons.add(addFishBtn);
      buttons.add(addSlowFishBtn);
      buttons.add(addCleanerBtn);
      
      JButton addJavaFernBtn = new JButton("Add Java Fern");
      JButton addLilyPadBtn = new JButton("Add LilyPad");
      JButton addWaterWeedBtn = new JButton("Add Water Weed");
      buttons.add(addJavaFernBtn);
      buttons.add(addLilyPadBtn);
      buttons.add(addWaterWeedBtn);
      
      JButton startBtn = new JButton("Start");
      JButton pauseBtn = new JButton("Pause");
      JButton restartBtn = new JButton("Restart");
      JButton feedBtn = new JButton("Feed Tank");
      JButton cleanBtn = new JButton("Clean Tank");
      buttons.add(startBtn);
      buttons.add(pauseBtn);
      buttons.add(restartBtn);
      buttons.add(feedBtn);
      buttons.add(cleanBtn);
      // Buttons located at the bottom
      add(buttons, BorderLayout.SOUTH);
      // Actions of the bottons
      addFishBtn.addActionListener(e -> tank.addFish());
      addSlowFishBtn.addActionListener(e -> tank.addSlowFish());
      addCleanerBtn.addActionListener(e -> tank.addCleaner());
    
      addJavaFernBtn.addActionListener(e -> tank.addJavaFern());
      addLilyPadBtn.addActionListener(e -> tank.addLilyPad());
      addWaterWeedBtn.addActionListener(e -> tank.addWaterWeed());
    
      feedBtn.addActionListener(e -> tank.feedTank());
      cleanBtn.addActionListener(e -> tank.cleanTank());
      // GUI updates every second
      timer = new Timer(1000, e -> updateGUI());
      startBtn.addActionListener(e -> timer.start());
      pauseBtn.addActionListener(e -> timer.stop());
      restartBtn.addActionListener(e -> {
         timer.stop();
         tank = new TankMain();
         tankPanel.setTank(tank);
         tankPanel.repaint();
         wasteBar.setValue(0);
      });
      pack();
      setVisible(true);
   }
   // Updates the GUI
   private void updateGUI() {
      tank.tick();
      wasteBar.setValue((int) tank.getWaste().getWasteLevel());
      tankPanel.repaint();
   }
   // Starts the simulation
   public static void main(String[] args) {
      SwingUtilities.invokeLater(TankGUI::new);
   }

}




