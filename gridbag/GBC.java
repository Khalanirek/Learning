/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridbag;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author Piotrek
 */
public class GBC extends GridBagConstraints 
{
    /**
     * Tworzy obiekt typu GBC z podanymi wartościami gridx i gridy oraz wszystkimi pozostałymi
     * parametrami ustawionymi na wartościdomyślne
     * @param gridx współrzędna gridx
     * @param gridy współrzędna gridy
     */
    public GBC(int gridx, int gridy)
    {
        this.gridx = gridx;
        this.gridy = gridy;
    }
    
    /**
     * Tworzy obiekt typu GBC z podanymi wartościami gridx, gridy, gridwidth i gridheight oraz
     * wszystkimi pozostałymi parametrami ustawionymi na wartości domyślne
     * @param gridx współrzędna gridx
     * @param gridy współrzędna gridy
     * @param gridWidth liczba zajmowanych komórek w poziomie
     * @param gridHeight liczba zajmowanych komórek w pionie
     */
    public GBC(int gridx, int gridy, int gridWidth, int gridHeight)
    {
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridWidth;
        this.gridheight = gridHeight;
    }
    
    /**
     * Ustawia parametr anchor
     * @param anchor wartość parametru anchor
     * @return this obiekt do dalszej modyfikacji
     */
    public GBC setAnchor(int anchor)
    {
        this.anchor = anchor;
        return this;
    }
    
    /**
     * Ustawia kierunek zapełniania
     * @param fill kierunek zapełnienia
     * @return this obiekt do dalszej modyfikacji
     */
    public GBC setFill(int fill)
    {
        this.fill = fill;
        return this;
    }
    
    /**
     * Ustawia parametry weight komórek
     * @param weightx parametr weight w poziomie
     * @param weighty parametr weight w pionie
     * @return this obiekt do dalszej modyfikacji
     */
    public GBC setWeight(double weightx, double weighty)
    {
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }
    
    /**
     * Ustawia dodatkową pustą przestrzeń w komórce
     * @param distance dopełnienie we wszystkich kierunkach
     * @return 
     */
    public GBC setInsets(int distance)
    {
        this.insets = new Insets(distance, distance, distance, distance);
        return this;
    }
    
    /**
     * Ustawia dopełnienia w komórce
     * @param top odstęp od górnej krawędzi
     * @param left odstęp od lewej krawędzi
     * @param bottom odstęp od dolnej krawędzi
     * @param right odstęp od prawej krawędzi
     * @return obiekt do dalszej modyfikacji
     */
    public GBC setInsets(int top, int left, int bottom, int right)
    {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }
    
    public GBC setIpad(int ipadx, int ipady)
    {
        this.ipadx = ipadx;
        this.ipady = ipady;
        return this;
    }
}
