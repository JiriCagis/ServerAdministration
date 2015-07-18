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
    }
    
    public static ServerService getServerService(){
        if(serverService==null)
            serverService = new ServerService();
        return serverService;
    }
    
    public ServerInfo createNewServerInfo(){
        ServerInfo serverInfo = new ServerInfo();
        serverInfo.setId(serversInfo.size());
        serversInfo.add(serverInfo);
        return serverInfo;
    }
    
    public void remove(ServerInfo serverInfo){
        serversInfo.remove(serverInfo);
    }
    
    public void update(ServerInfo serverInfo){
        for(int i=0;i<serversInfo.size();i++)
        {
            if(serversInfo.get(i).getId() == serverInfo.getId())
            {
                serversInfo.set(i, serverInfo);
            }
        }
    }
    
    public List<ServerInfo> getAllServersInfo(){
        return serversInfo;
    }
    
}
