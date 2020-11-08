package org.amazon.freebox.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DownloadTask {

    /* @formatter:off
    download_url (string) – The URL
    download_url_list (string) – A list of URL separated by a new line delimiter (use download_url or download_url_list)
    download_dir (string) – The download destination directory (optional: will use the configuration download_dir by default)
    recursive (bool) – If true the download will be recursive
    username (string) – Auth username (optional)
    password (string) – Auth password (optional)
    archive_password (string) – The password required to extract downloaded content (only relevant for nzb)
    cookies (string) – The http cookies (to be able to pass session cookies along with url)
    @formatter:on */

    @XmlElement(name = "download_url")
    public String downloadUrl;

    public DownloadTask(String downloadUrl) {
        super();
        this.downloadUrl = downloadUrl;
    }
}
