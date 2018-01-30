package by.itacademy.downloadAndParsing;

import by.itacademy.entity.Root;

import java.io.File;

public interface Parsing {

    /**
     * Parsing data from files to entity
     * @param file  for parsing
     */
    Root parsingFile(File file);
}

