package utils.xmlParser;

import java.io.File;
import java.util.List;

public interface XmlParser<T> {
    public List<T> parse(File xmlFile);
    public void save(List<T> list, File outFile);
}
