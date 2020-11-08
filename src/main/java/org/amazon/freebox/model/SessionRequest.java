package org.amazon.freebox.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SessionRequest {

    @XmlElement(name = "app_id")
    public String appId;

    @XmlElement(name = "password")
    public String password;

    public SessionRequest(String appId, String password) {
        super();
        this.appId = appId;
        this.password = password;
    }
}