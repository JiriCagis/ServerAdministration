package logic.synchronize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SynchronizeTask extends Thread {

    private List<SynchronizeFolder> list = null;

    public SynchronizeTask() {
        list = Collections.synchronizedList(new LinkedList<SynchronizeFolder>());
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                List<SynchronizeFolder> safeList = new ArrayList<SynchronizeFolder>();

                synchronized (list) {
                    for (SynchronizeFolder synchronizeFolder : list) {
                        safeList.add(synchronizeFolder);
                    }
                }

                for (SynchronizeFolder synchronizeFolder : safeList) {
                    if (checkChanges(synchronizeFolder)) {
                        copyFiles(synchronizeFolder);
                        System.out.print("Copy files for folder: " + synchronizeFolder.sourceFolder.getPath() + "\n");
                    }
                }
                Thread.sleep((long) 10000);

            } catch (Exception e) {
                 e.printStackTrace();
            }
        }
    }

    private boolean checkChanges(SynchronizeFolder synchronizeFolder) {
        //to do
        return true;
    }

    private void copyFiles(SynchronizeFolder synchronizeFolder) {
        //to do 
    }

    public void add(SynchronizeFolder synchronizeFolder) {
        if (!list.contains(synchronizeFolder)) {
            list.add(synchronizeFolder);
        }
    }

    public void remove(SynchronizeFolder synchronizeFolder) {
        list.remove(synchronizeFolder);
    }

}
