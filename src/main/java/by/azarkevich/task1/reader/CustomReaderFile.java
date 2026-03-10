package by.azarkevich.task1.reader;

import by.azarkevich.task1.exception.IntArrayException;

import java.util.List;

public interface CustomReaderFile {
    List<String> readLines(String filePath) throws IntArrayException;
}
