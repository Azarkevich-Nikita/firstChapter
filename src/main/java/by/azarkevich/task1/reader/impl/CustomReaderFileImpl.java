package by.azarkevich.task1.reader.impl;

import by.azarkevich.task1.exception.IntArrayException;
import by.azarkevich.task1.reader.CustomReaderFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomReaderFileImpl implements CustomReaderFile {
    private static final Logger logger = LogManager.getLogger(CustomReaderFileImpl.class);
    private static final String DEFAULTFILEPATH =  "data/data.txt";

    @Override
    public List<String> readLines(String filePath) throws IntArrayException {
        logger.info("readLines called");
        List<String> lines = new ArrayList<>();
        try{
            Path path = Paths.get(filePath != null ? filePath : DEFAULTFILEPATH);

            if(!Files.exists(path)){
                logger.info("File " + path + " does not exist");
                path = Paths.get(DEFAULTFILEPATH);
            }
            lines = Files.readAllLines(path);

        } catch (IOException e) {
            throw new IntArrayException(e.getMessage());
        }
        return lines;
    }
}
