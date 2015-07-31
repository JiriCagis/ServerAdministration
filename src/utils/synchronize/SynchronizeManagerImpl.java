package utils.synchronize;

import java.io.File;

public class SynchronizeManagerImpl implements SynchronizeManager{
    private SynchronizeTask synchronizeTask = null;
    
    public SynchronizeManagerImpl(){
        synchronizeTask = new SynchronizeTask();
        synchronizeTask.start();
    }

    @Override
    public void add(File sourceFolder, File targetFolder) {
        SynchronizeFolder synchronizeFolder = new SynchronizeFolder(sourceFolder, targetFolder);
        synchronizeTask.add(synchronizeFolder);
    }

    @Override
    public void remove(File sourceFolder, File targetFolder) {
        SynchronizeFolder synchronizeFolder = new SynchronizeFolder(sourceFolder, targetFolder);
        synchronizeTask.remove(synchronizeFolder);
    }
    
}
