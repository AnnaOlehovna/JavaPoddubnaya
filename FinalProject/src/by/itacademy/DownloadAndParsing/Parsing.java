package by.itacademy.DownloadAndParsing;

import by.itacademy.Entity.Root;

import java.io.File;

public interface Parsing {

    /**
     * Parsing data from files to Entity
     * @param file  for parsing
     */
    Root parsingFile(File file);
}

