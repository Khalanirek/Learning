/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileChooser;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author Piotrek
 */
public class ImagePreviewer extends JLabel
{
    public ImagePreviewer(JFileChooser chooser)
    {
        setPreferredSize(new Dimension(100, 100));
        setBorder(BorderFactory.createEtchedBorder());
        chooser.addPropertyChangeListener(event -> {
            if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
            {
                //Użytkownik wybrał inny plik
                File f = (File) event.getNewValue();
                if (f == null)
                {
                    setIcon(null);
                    return;
                }
                
                //Wczytywanie obrazu jako ikony
                ImageIcon icon = new ImageIcon(f.getPath());
                
                //Skalowanie obrazu, jeśli jest zbyt duży na ikonę
                if (icon.getIconWidth() > getWidth()) icon = new 
                    ImageIcon(icon.getImage().getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));
                setIcon(icon);
            }
        });
    }
}
