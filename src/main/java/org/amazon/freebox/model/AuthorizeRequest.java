package org.amazon.freebox.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorizeRequest {

    @XmlElement(name = "app_id")
    private final String appId;
    @XmlElement(name = "app_name")
    private final String appName;
    @XmlElement(name = "app_version")
    private final String appVersion;
    @XmlElement(name = "device_name")
    private final String deviceName;

    public AuthorizeRequest(final String appId, final String appName, final String appVersion, final String deviceName) {
        super();
        this.appId = appId;
        this.appName = appName;
        this.appVersion = appVersion;
        this.deviceName = deviceName;
    }
}