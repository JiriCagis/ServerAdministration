/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.listeners;

import data.ServerInfo;

/**
 *
 * @author adminuser
 */
public interface MainWindowListener {
    public void updateServers();
    public void openNewServerDialog();
    public void openConfigServerDialog(ServerInfo serverInfo);
    public void openHelpDialog();
}
