/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.MenuEnum;
import dto.MenuDto;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utils.ColorUtils;
import view.PnHomePage;
import view.PnStudentManager;
import view.pnClassManager;
import view.pnStaticsticalManager;

/**
 *
 * @author PC
 */
public class Navigator {
    private MenuEnum pressedMenu;
    private final JPanel pnMenu;
    private List<MenuDto> menus;

    public Navigator(JPanel pnMenu) {
        this.pnMenu = pnMenu;
    }

    public void setStartPage() {
        pressedMenu=MenuEnum.HOMEPAGE;
        pnMenu.removeAll();
        pnMenu.setLayout(new BorderLayout());
        pnMenu.add(new PnHomePage());

        pnMenu.validate();
        pnMenu.repaint();
    }

    public void setEvent(List<MenuDto> menus) {
        this.menus = menus;
        menus.forEach(menuDto -> {
            menuDto.getCurLabel().addMouseListener(new LabelMenuEvent(menuDto));
        });
    }

    class LabelMenuEvent extends MouseAdapter {

        private JPanel selectedPanel;
        private MenuEnum curMenuName;
        private JPanel curPanel;
        private JLabel cuLabel;

        private LabelMenuEvent(MenuDto menuDto) {
            this.curMenuName = menuDto.getName();
            this.curPanel = menuDto.getCurPanel();
            this.cuLabel = menuDto.getCurLabel();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            pressedMenu= curMenuName;
            menus.forEach(menuDto -> {
                menuDto.getCurPanel().setBackground(ColorUtils.NORMAL_MENU);
            });
            curPanel.setBackground(ColorUtils.HOVER_MENU);
            switch (curMenuName) {
                case HOMEPAGE:
                    selectedPanel = new PnHomePage();
                    break;
                case STUDENT_MANAGER:
                    selectedPanel = new PnStudentManager();
                    break;
                case CLASS_MANAGER:
                    selectedPanel = new pnClassManager();
                    break;
                case COURSE_MANAGER:
                    selectedPanel = new PnStudentManager();
                    break;
                case STATISTICAL_MANAGER:
                    selectedPanel = new pnStaticsticalManager();
                    break;
            }
            pnMenu.removeAll();
            pnMenu.setLayout(new BorderLayout());
            pnMenu.add(selectedPanel);

            pnMenu.validate();
            pnMenu.repaint();

        }

        @Override
        public void mouseEntered(MouseEvent e) {
             curPanel.setBackground(ColorUtils.HOVER_MENU);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(pressedMenu!=curMenuName){
                curPanel.setBackground(ColorUtils.NORMAL_MENU);
            }
        }

    }

}
