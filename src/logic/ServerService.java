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
    
    
    private ServerService(){
        serversInfo=new ArrayList<ServerInfo>(10);    
        ServerInfo info = new ServerInfo();
        info.setId(1);
        info.setServerName("server 1");
        serversInfo.add(info);
    }
    
    public static ServerService getServerService(){
        if(serverService==null)
            serverService = new ServerService();
        return serverService;
    }
    
    public void add(ServerInfo serverInfo){
        serversInfo.add(serverInfo);
    }
    
    public void remove(ServerInfo serverInfo){
        serversInfo.remove(serverInfo);
    }
    
    public List<ServerInfo> getAllServersInfo(){
        return serversInfo;
    }
    
}
