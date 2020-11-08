package org.amazon.freebox.model;

import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResultResponse {
    @XmlElement(name = "app_token")
    public String appToken;
    @XmlElement(name = "password_salt")
    public String passwordSalt;
    @XmlElement(name = "password_set")
    public String passwordSet;
    @XmlElement(name = "id")
    public String id;
    @XmlElement(name = "track_id")
    public String track_id;
    @XmlElement(name = "logged_in")
    public boolean loggedIn;
    @XmlElement(name = "challenge")
    public String challenge;
    @XmlElement(name = "permissions")
    public Map<String, Object> permissions;
    @XmlElement(name = "session_token")
    public String sessionToken;
}