package server.view;

import annotations.Location;
import java.awt.Component;
import javax.swing.*;
import server.model.AuthorInfo;
import java.lang.reflect.*;

/**
 * Class to display info about program
 * @author Janusz Czornik
 * @version 1.0
 */

public class InfoView extends JFrame {
    /**
     * Store JComponent
     */
    JComponent component = (JComponent) getContentPane();
    
    /**
     * First panel
     */
    @Location(locationName = "component") 
    JPanel p1 = new JPanel();
    
    /**
     * Second panel
     */
    @Location(locationName = "component")
    JPanel p2 = new JPanel();
    
    /**
     * Third panel
     */
    @Location(locationName = "component")
    JPanel p3 = new JPanel();
    
    /**
     * Label for author name
     */
    @Location(locationName = "p1")
    JLabel authorName = new JLabel(AuthorInfo.getAuthor());
    /**
     * Label for version
     */
    @Location(locationName = "p2")
    JLabel version = new JLabel(AuthorInfo.getVersion());
    
    /**
     * Label for copyrigths
     */
    @Location(locationName = "p3")
    JLabel copyrights = new JLabel(AuthorInfo.getCopyrights());
    
    
    /**
     * Constructor
     */
    public InfoView() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        component.setLayout(new BoxLayout(component, BoxLayout.Y_AXIS));
        try {
            loadCopmponents();
        } catch (Exception e) {
            return;
        }
        pack();
    }
    
    
    /**
     * Function that load components
     * @throws Exception standard exception
     */
    private void loadCopmponents() throws Exception {
        Class ourClass = getClass();
        for(Field f : ourClass.getDeclaredFields()) {
            Location anno = f.getAnnotation(Location.class);
            if(anno == null)
                continue;
            String contName = anno.locationName();
            Field contField = ourClass.getDeclaredField(contName);
            Object container = contField.get(this);
            Method m = container.getClass().getMethod("add", Component.class);
            m.invoke(container, f.get(this));
        }
    }
}
