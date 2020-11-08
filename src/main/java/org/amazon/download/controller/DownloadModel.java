package org.amazon.download.controller;

public class DownloadModel implements Comparable<DownloadModel> {

    public String title;
    public String url;
    public int up;
    public String torrentUrl;

    public DownloadModel(String title, String url, int up) {
        super();
        this.title = title;
        this.url = url;
        this.up = up;
    }

    @Override
    public int compareTo(DownloadModel o) {
        return o.up - up;
    }

    @Override
    public String toString() {
        return "DownloadModel [title=" + title + ", url=" + url + ", up=" + up + ", torrentUrl=" + torrentUrl + "]";
    }
}
