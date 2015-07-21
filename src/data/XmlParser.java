package data;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlParser {
    
    public static List<ServerInfo> parse(File xmlFile){
        try {
            FileInputStream fis = new FileInputStream(xmlFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDecoder = new XMLDecoder(bis);
            return (List<ServerInfo>) xmlDecoder.readObject();
        } catch (FileNotFoundException ex) {
            return new ArrayList<>();
        }
    }
    
    public static void save(List<ServerInfo> list, File outFile){
        try {
            FileOutputStream fos = new FileOutputStream(outFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            XMLEncoder xmlEncoder = new XMLEncoder(bos);
            xmlEncoder.writeObject(list);
            xmlEncoder.close();        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
