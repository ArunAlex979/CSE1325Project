package gui;

import store.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TerminalWindow extends JFrame{
    
    private Store store;
    private JLabel display;
    
    public TerminalWindow(String name){
        this.store = new Store(name);
    }

    public TerminalWindow(Store store){
        this.store = store;
    }

}
