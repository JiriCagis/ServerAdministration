package logic;

import data.ServerInfo;
import data.XmlParser;
import java.io.File;
import java.util.List;

public class ServerService {

    private static ServerService serverService;
    private List<ServerInfo> serversInfo;
    private final File outFile = new File("configuration.xml");

    private ServerService() {
        serversInfo = XmlParser.parse(outFile);
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

     public List<ServerInfo> getServersInfo() {
        return serversInfo;
    }
    public void startServer(ServerInfo serverInfo) {
        serverInfo.setRun(true);
        System.out.println("Start server" + serverInfo.getServerName());
    }

    public void stopServer(ServerInfo serverInfo) {
        serverInfo.setRun(false);
        System.out.println("Stop server" + serverInfo.getServerName());
    }

    public void restartServer(ServerInfo serverInfo) {
        System.out.println("Restart server" + serverInfo.getServerName());
    }

    public boolean isAvailable(ServerInfo info) {
        return true;
    } 
    
    public void saveState(){
        XmlParser.save(serversInfo, outFile);
    }
}
