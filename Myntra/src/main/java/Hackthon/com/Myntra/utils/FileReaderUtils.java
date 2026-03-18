package Hackthon.com.Myntra.utils;

import java.nio.file.*;
import java.util.*;

public class FileReaderUtils {

    public static List<String> readProducts(String filePath) throws Exception {

        List<String> products = Files.readAllLines(Paths.get(filePath));
        return products;

    }
}