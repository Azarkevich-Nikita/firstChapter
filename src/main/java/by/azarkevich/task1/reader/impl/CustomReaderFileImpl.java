package by.azarkevich.task1.reader.impl;

import by.azarkevich.task1.exception.IntArrayException;
import by.azarkevich.task1.reader.CustomReaderFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomReaderFileImpl implements CustomReaderFile {

    private static final String DEFAULTFILEPATH =  "data/data.txt";

    @Override
    public List<String> readLines(String filePath) throws IntArrayException {
        List<String> lines = new ArrayList<>();
        try{
            Path path = Paths.get(filePath != null ? filePath : DEFAULTFILEPATH);

            if(!Files.exists(path)){
                path = Paths.get(DEFAULTFILEPATH);
            }
            lines = Files.readAllLines(path);

        } catch (IOException e) {
            throw new IntArrayException(e.getMessage());
        }
        return lines;
    }
}
