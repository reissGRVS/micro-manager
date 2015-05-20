package gui;

import coordinates.AffineUtils;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.util.prefs.Preferences;
import main.Magellan;
import misc.JavaUtils;
import org.micromanager.MMStudio;

/**
 *
 * @author Henry
 */
public class StartupHelpWindow extends javax.swing.JFrame {

       private static final Color DARK_GREEN = new Color(0, 128, 0);

   
   int stepIndex_ = 0;
   
   /**
    * Creates new form StartupHelpWindow
    */
   public StartupHelpWindow() {
      initComponents();
      this.setVisible(true);
      updateText();
   }

   private void updateText() {
      if (stepIndex_ == 0 ) {
         textArea_.setText("<html>Welcome to Micro-Magellan. This help dialog will help check that your microscope is "
                 + "configured properly to use Micro-Magellan.</html>" );         
         statusLabel_.setText("");
         statusLabel_.setForeground(Color.black);
      } else if (stepIndex_ == 1 ) {
         textArea_.setText("<html>Using surfaces in Magellan to alter settings and/or control acqusitions requires" +
                 " knowing the relationship between the polarity of the focus drive and movement towards/away from the sample. "
                 + "Some focus drives may report this automatically, but for many it will need to be manually configured in"
                 + " the <b>Hardware Configuration Wizard</b> (under the <b>Tools</b> menu)</html>");
         boolean known = false;
         try {
            String zName = Magellan.getCore().getFocusDevice();
            known = Magellan.getCore().getFocusDirection(zName) != 0;
         } catch (Exception e) {
            
         }
         statusLabel_.setText("<html><b>Polrity " + (known ? "known" : "unknown") + " for current focus drive</b></html>");
         statusLabel_.setForeground(known ? DARK_GREEN : Color.red);
      } else if (stepIndex_ == 2) {
         textArea_.setText("<html>Magellan allows you to navigate through a high resolution image of a sample "
                 + "by stitching together multiple fields of into a single contiguous image. In order to do this "
                 + "accurately, Magellan must know the relationship between the coordinate space of the image and "
                 + "the coordinate space of the sample. This is done by associating an affine transformation matrix "
                 + "with each pixel size calibration. This calibration can be initialized or changed using the <b>Calibrate</b> "
                 + "button on the bottom of the Magellan main window. <a href=\"https://micro-manager.org/wiki/Micro-Manager"
                 + "_Configuration_Guide#Pixel_Size_Calibration\"> More information about setting up pixel size calibrations "
                 + "can found on the Micro-Manager website</a></html>");
         boolean known = false;
         try {
            String pix = Magellan.getCore().getCurrentPixelSizeConfig();
            //Get affine transform from prefs
            Preferences prefs = Preferences.userNodeForPackage(MMStudio.class);
            known = JavaUtils.getObjectFromPrefs(prefs, "affine_transform_" + pix, (AffineTransform) null) != null;
         } catch (Exception e) {
            
         }
         statusLabel_.setText("<html><b>Affine transform " + (known ? "detected" : "not detected") + " for current pixel size calibration</b></html>");
         statusLabel_.setForeground(known ? DARK_GREEN : Color.red);
      } else if (stepIndex_ == 3) {
         textArea_.setText("<html>Magellan provides a device control panel it the top of its main window as a convenience for quickly changing"
                 + "device properties or property groups during acquisition. The <b>Configure device control</b> button at the "
                 + "bottom of the main Magellan window allows you to pick which properties/groups appear in this area</html>");
                  statusLabel_.setText("");
      }
      pageLabel_.setText((stepIndex_ + 1) + "/" + 4);
   }
   
   
   
   
   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nextButton_ = new javax.swing.JButton();
        closeButton_ = new javax.swing.JButton();
        prevButton_ = new javax.swing.JButton();
        pageLabel_ = new javax.swing.JLabel();
        statusLabel_ = new javax.swing.JLabel();
        textArea_ = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Micro-Magellan configuration help");

        nextButton_.setText("Next");
        nextButton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButton_ActionPerformed(evt);
            }
        });

        closeButton_.setText("Close");
        closeButton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButton_ActionPerformed(evt);
            }
        });

        prevButton_.setText("Prev");
        prevButton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButton_ActionPerformed(evt);
            }
        });

        pageLabel_.setText("jLabel1");

        statusLabel_.setText(" ");

        textArea_.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textArea_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addComponent(statusLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(closeButton_)
                        .addGap(93, 93, 93)
                        .addComponent(prevButton_)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nextButton_)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pageLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textArea_, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(statusLabel_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton_)
                    .addComponent(prevButton_)
                    .addComponent(nextButton_)
                    .addComponent(pageLabel_))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void prevButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButton_ActionPerformed
      stepIndex_ = Math.max(stepIndex_-1, 0);
      updateText();
   }//GEN-LAST:event_prevButton_ActionPerformed

   private void closeButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButton_ActionPerformed
      this.setVisible(false);
      this.dispose();
   }//GEN-LAST:event_closeButton_ActionPerformed

   private void nextButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButton_ActionPerformed
      stepIndex_ = Math.min(stepIndex_+1, 3);
      updateText();
   }//GEN-LAST:event_nextButton_ActionPerformed

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      /*
       * Set the Nimbus look and feel
       */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
       * If Nimbus (introduced in Java SE 6) is not available, stay with the
       * default look and feel. For details see
       * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(StartupHelpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(StartupHelpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(StartupHelpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(StartupHelpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /*
       * Create and display the form
       */
      java.awt.EventQueue.invokeLater(new Runnable() {

         public void run() {
            new StartupHelpWindow().setVisible(true);
         }
      });
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton_;
    private javax.swing.JButton nextButton_;
    private javax.swing.JLabel pageLabel_;
    private javax.swing.JButton prevButton_;
    private javax.swing.JLabel statusLabel_;
    private javax.swing.JLabel textArea_;
    // End of variables declaration//GEN-END:variables
}
