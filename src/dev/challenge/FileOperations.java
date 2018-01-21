package dev.challenge;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface FileOperations {
    @SuppressWarnings("unchecked")
    static HashMap<String, ArrayList<String>> readFile(String filename) throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream listFile = new ObjectInputStream(new FileInputStream(filename));
            return (HashMap<String, ArrayList<String>>)listFile.readObject();
        } catch (FileNotFoundException | EOFException e){
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(filename)));
            return new HashMap<>();
        }
    }

    static void writeFile(String filename, Map<String, ArrayList<String>> list) throws IOException {
        ObjectOutputStream listFile = new ObjectOutputStream(new FileOutputStream(filename));
        listFile.writeObject(list);
        listFile.close();
    }
}