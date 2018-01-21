package dev.challenge;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Map;
import dev.challenge.FileOperations;
import dev.challenge.HashManager;

public class AccessManager implements FileOperations,HashManager {
    private Map<String,ArrayList<String>> whitelist;
    private Map<String,ArrayList<String>> blacklist;

    public AccessManager() throws IOException, ClassNotFoundException {
        blacklist = FileOperations.readFile("blacklist.txt");
        whitelist = FileOperations.readFile("whitelist.txt");
    }

    private void verify(String url) {
        try {
            if(HashManager.isOnList(url,whitelist)){
                System.out.println("safe");
            }
            else if(HashManager.isOnList(url,blacklist)){
                System.out.println("unsafe");
            }
            else {
                System.out.println("unknown");
            }
        } catch(NullPointerException e){
            System.out.println("unknown");
        }
    }

    private void addWhitelist(String url) {
        try {
            HashManager.addToList(url,whitelist);
            FileOperations.writeFile("whitelist.txt",whitelist);
            System.out.println(url + " was successfully added to whitelist");
        }
        catch (Exception e){
            System.out.println("Error when adding URL");
        }
    }

    private void addBlacklist(String url) {
        try {
            HashManager.addToList(url,blacklist);
            FileOperations.writeFile("blacklist.txt",blacklist);
            System.out.println(url + " was successfully added to blacklist");
        }
        catch (Exception e){
            System.out.println("Error when adding URL");
        }
    }

    private void showWhitelist() {
        HashManager.retrieveList(whitelist);
    }

    private void showBlacklist() {
        HashManager.retrieveList(blacklist);
    }

    private void removeWhitelist(String url) {
        try {
            HashManager.removeFromList(url,whitelist);
            FileOperations.writeFile("whitelist.txt",whitelist);
            System.out.println(url + " was successfully removed from whitelist.");
        }
        catch (Exception e){
            System.out.println("Error when removing URL");
        }
    }

    private void removeBlacklist(String url) {
        try {
            HashManager.removeFromList(url,blacklist);
            FileOperations.writeFile("blacklist.txt",blacklist);
            System.out.println(url + " was successfully removed from blacklist.");
        }
        catch (Exception e){
            System.out.println("Error when removing URL");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AccessManager manager = new AccessManager();

        try {
            switch(args[0]){
                case "verify": manager.verify(args[1]);
                    break;
                case "add-whitelist": manager.addWhitelist(args[1]);
                    break;
                case "add-blacklist": manager.addBlacklist(args[1]);
                    break;
                case "show-whitelist": manager.showWhitelist();
                    break;
                case "show-blacklist": manager.showBlacklist();
                    break;
                case "remove-whitelist": manager.removeWhitelist(args[1]);
                    break;
                case "remove-blacklist": manager.removeBlacklist(args[1]);
                    break;
                default: throw new InvalidParameterException("Missing Parameters");
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
