package data;

public class ServerInfo {
    private int id;
    private boolean run;
    private String serverName;
    private String startScript;
    private String restartScript;
    private String stopScript;
    private boolean automaticSynchnize;
    private String sourceFolder;
    private String targetFolder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public String getStartScript() {
        return startScript;
    }

    public void setStartScript(String startScript) {
        this.startScript = startScript;
    }

    public String getRestartScript() {
        return restartScript;
    }

    public void setRestartScript(String restartScript) {
        this.restartScript = restartScript;
    }

    public String getStopScript() {
        return stopScript;
    }

    public void setStopScript(String stopScript) {
        this.stopScript = stopScript;
    }

    public boolean isAutomaticSynchnize() {
        return automaticSynchnize;
    }

    public void setAutomaticSynchnize(boolean automaticSynchnize) {
        this.automaticSynchnize = automaticSynchnize;
    }

    public String getSourceFolder() {
        return sourceFolder;
    }

    public void setSourceFolder(String sourceFolder) {
        this.sourceFolder = sourceFolder;
    }

    public String getTargetFolder() {
        return targetFolder;
    }

    public void setTargetFolder(String targetFolder) {
        this.targetFolder = targetFolder;
    }
    
    
    
    
}
