/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.MenuDto;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JPanel;
import view.PnHomePage;

/**
 *
 * @author PC
 */
public class Navigator {
    private final JPanel pnMenu;

    public Navigator(JPanel pnMenu) {
        this.pnMenu=pnMenu;
    }

    public void setStartPage() {
        pnMenu.removeAll();
        pnMenu.setLayout(new BorderLayout());
        pnMenu.add(new PnHomePage());
        
        pnMenu.validate();
        pnMenu.repaint();
    }
    
    public void setEvent(List<MenuDto> menus){
        menus.forEach(menuDto->{
            menuDto.getCurLabel().addMouseListener(new LabelMenuEvent());
        });
    }
    
    class LabelMenuEvent extends MouseAdapter{


        private LabelMenuEvent() {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }
        
        
    }
    
    
}
