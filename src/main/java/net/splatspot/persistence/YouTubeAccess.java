package net.splatspot.persistence;

import edu.matc.utilities.PropertiesLoader;

import com.google.api.services.youtube.YouTube;

public class YouTubeAccess implements PropertiesLoader {

    public YouTubeAccess() {
        // TODO get key using loadProperties
        // TODO get the service, which will require authorization
    }

    public String getVideoName(String id) {


        YouTube.Videos.List request;
        return "";
    }
}
