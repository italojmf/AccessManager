package dev.challenge;

import java.util.ArrayList;
import java.util.Map;

public interface HashManager {
    static boolean isOnList(String url, Map<String, ArrayList<String>> list) throws NullPointerException{
        String urlKey = "";
        urlKey = HashManager.regexMatcher(urlKey, url);
        ArrayList<String> urlList = list.get(urlKey);
        return urlList.contains(url);
    }
    static void addToList(String url, Map<String, ArrayList<String>> list){
        String urlKey = "";
        urlKey = HashManager.regexMatcher(urlKey, url);
        ArrayList<String> urlList = new ArrayList<>();
        try {
            if(list.get(urlKey) != null){
                urlList = list.get(urlKey);
            }
        } catch (NullPointerException e){
            throw new Error(e);
        }
        if(!urlList.contains(url)){
            urlList.add(url);
        }
        list.put(urlKey,urlList);
    }

    static void removeFromList(String url, Map<String, ArrayList<String>> list){
        String urlKey = "";
        urlKey = HashManager.regexMatcher(urlKey, url);
        ArrayList<String> urlList = new ArrayList<>();
        try {
            if(list.get(urlKey) != null) {
                urlList = list.get(urlKey);
                urlList.remove(url);
            }
        } catch (NullPointerException e){
            throw new Error(e);
        }
        list.put(urlKey,urlList);
    }

    static void retrieveList(Map<String, ArrayList<String>> list){
        ArrayList<String> urlList;
        for(String key : list.keySet()){
            urlList = list.get(key);
            System.out.println(urlList);
        }
    }
    static String regexMatcher(String urlKey, String url){
        for( URLBases urlRegex : URLBases.values()){
            if(url.matches(urlRegex.toString())) {
                urlKey = urlRegex.toString();
                return urlKey;
            }
        }
        return "";
    }
}
