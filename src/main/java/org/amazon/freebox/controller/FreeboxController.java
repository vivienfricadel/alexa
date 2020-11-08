package org.amazon.freebox.controller;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FreeboxController extends FreeboxAuthController {

    public void addDownloadUrl(String url) {

        freeboxResource.addDownloadUrl(getSessionToken(), url);
    }
}
