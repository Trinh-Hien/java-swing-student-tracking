/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import common.MenuEnum;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class MenuDto {
    private MenuEnum name;
    private JPanel curPanel;
    private JLabel curLabel;

    public MenuDto() {
    }

    public MenuDto(MenuEnum name, JPanel curPanel, JLabel curLabel) {
        this.name = name;
        this.curPanel = curPanel;
        this.curLabel = curLabel;
    }

    public MenuEnum getName() {
        return name;
    }

    public void setName(MenuEnum name) {
        this.name = name;
    }

    public JPanel getCurPanel() {
        return curPanel;
    }

    public void setCurPanel(JPanel curPanel) {
        this.curPanel = curPanel;
    }

    public JLabel getCurLabel() {
        return curLabel;
    }

    public void setCurLabel(JLabel curLabel) {
        this.curLabel = curLabel;
    }

    
    
    
    
}
