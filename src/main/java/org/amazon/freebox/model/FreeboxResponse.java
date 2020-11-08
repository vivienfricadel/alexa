package org.amazon.freebox.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FreeboxResponse {
    @XmlElement(name = "success")
    public boolean success;
    @XmlElement(name = "result")
    public ResultResponse result;
    @XmlElement(name = "uid")
    public String uid;
    @XmlElement(name = "msg")
    public String msg;
    @XmlElement(name = "error_code")
    public String errorCode;
}