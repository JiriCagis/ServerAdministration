package business;

import data.ServerInfo;
import utils.xmlParser.XmlParserImpl;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.synchronize.SynchronizeManager;
import utils.synchronize.SynchronizeManagerImpl;
import utils.xmlParser.XmlParser;

public class ServerService {

    private static ServerService serverService;
    private List<ServerInfo> serversInfo;
    private final File outFile = new File("configuration.xml");
    private final XmlParser xmlParser;
    private SynchronizeManager synchronizeManager;

    private ServerService() {
        xmlParser = new XmlParserImpl<ServerInfo>();
        serversInfo = xmlParser.parse(outFile);
        synchronizeManager = new SynchronizeManagerImpl(200);
    }

    public static ServerService getInstance() {
        if (serverService == null) {
            serverService = new ServerService();
        }
        return serverService;
    }

    public void remove(ServerInfo serverInfo) {
        serversInfo.remove(serverInfo);
    }

    public void addOrUpdate(ServerInfo serverInfo) {
        if (serverInfo.getId() == null) {
            serverInfo.setId(serversInfo.size());
            serversInfo.add(serverInfo);
        } else {
            for (int i = 0; i < serversInfo.size(); i++) {
                if (Objects.equals(serversInfo.get(i).getId(), serverInfo.getId())) {
                    serversInfo.set(i, serverInfo);
                    break;
                }
            }
        }
    }

    public List<ServerInfo> getServersInfo() {
        return serversInfo;
    }

    public void startServer(ServerInfo serverInfo) {
        if (isAvailable(serverInfo)) {
            serverInfo.setRun(true);
            try {
                Runtime.getRuntime().exec("cmd /c start " + serverInfo.getStartScript());
            } catch (IOException ex) {
                Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void stopServer(ServerInfo serverInfo) {
        if (isAvailable(serverInfo)) {
            serverInfo.setRun(false);
            try {
                Runtime.getRuntime().exec("cmd /c start " + serverInfo.getStopScript());
            } catch (IOException ex) {
                Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void restartServer(ServerInfo serverInfo) {
        if (isAvailable(serverInfo)) {
            try {
                Runtime.getRuntime().exec("cmd /c start " + serverInfo.getRestartScript());
            } catch (IOException ex) {
                Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean isAvailable(ServerInfo info) {
        File startScript = new File(info.getStartScript());
        File restartScript = new File(info.getRestartScript());
        File stopScript = new File(info.getStopScript());
        File sourceFolder = new File(info.getSourceFolder());
        File targetFolder = new File(info.getTargetFolder());

        return (startScript.isFile() && restartScript.isFile() && stopScript.isFile()
                && (info.isAutomaticSynchnize() ? (sourceFolder.isDirectory() && targetFolder.isDirectory()) : true));
    }

    public void saveState() {
        xmlParser.save(serversInfo, outFile);
    }
}
