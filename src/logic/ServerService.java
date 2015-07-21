/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.ServerInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adminuser
 */
public class ServerService {

    private static ServerService serverService;
    private List<ServerInfo> serversInfo;

    private ServerService() {
        serversInfo = new ArrayList<ServerInfo>(10);
    }

    public static ServerService getInstance() {
        if (serverService == null) {
            serverService = new ServerService();
        }
        return serverService;
    }

    public ServerInfo createNewServerInfo() {
        ServerInfo serverInfo = new ServerInfo();
        serverInfo.setId(serversInfo.size());
        serversInfo.add(serverInfo);
        return serverInfo;
    }

    public void remove(ServerInfo serverInfo) {
        serversInfo.remove(serverInfo);
    }

    public void update(ServerInfo serverInfo) {
        for (int i = 0; i < serversInfo.size(); i++) {
            if (serversInfo.get(i).getId() == serverInfo.getId()) {
                serversInfo.set(i, serverInfo);
            }
        }
    }

    public void startServer(int serverId) {
        for (int i = 0; i < serversInfo.size(); i++) {
            if (serversInfo.get(i).getId() == serverId) {
                serversInfo.get(i).setRun(true);
            }
        }
        System.out.println("Start server" + serverId);
    }

    public void stopServer(int serverId) {
        for (int i = 0; i < serversInfo.size(); i++) {
            if (serversInfo.get(i).getId() == serverId) {
                serversInfo.get(i).setRun(false);
            }
        }
        System.out.println("Stop server" + serverId);
    }

    public void restartServer(int serverId) {
        System.out.println("Restart server" + serverId);
    }

    public boolean isAvailable(ServerInfo info) {
        return true;
    }

    public List<ServerInfo> getServersInfo() {
        return serversInfo;
    }

    public void setServersInfo(List<ServerInfo> serversInfo) {
        this.serversInfo = serversInfo;
    }

}
