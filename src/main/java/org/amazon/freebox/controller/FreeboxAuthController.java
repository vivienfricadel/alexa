package org.amazon.freebox.controller;

import javax.inject.Inject;

import org.amazon.freebox.model.AuthorizeRequest;
import org.amazon.freebox.model.FreeboxResponse;
import org.amazon.freebox.model.SessionRequest;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.eclipse.microprofile.rest.client.inject.RestClient;

public abstract class FreeboxAuthController {

    private static final String APP_ID = "AmazonSkill";
    private static final String APP_NAME = "AmazonSkill";
    private static final String APP_VERSION = "v1.0";
    private static final String APP_DEVICE = "AmazonSkill";
    private static final String APP_TOKEN = "55GFOG2xJHZCIRkHYPfYk1IitRpAx+w8SwikJGCtPBK99aRUcxIy/4OUmoI78J2p";

    @Inject
    @RestClient
    FreeboxResource freeboxResource;

    private String sessionToken;

    protected FreeboxResponse authorize() {
        return freeboxResource.authorize(new AuthorizeRequest(APP_ID, APP_NAME, APP_VERSION, APP_DEVICE));
    }

    protected String getSessionToken() {

        // Login
        if (sessionToken == null) {
            FreeboxResponse loginResp = freeboxResource.login();
            String hex = new HmacUtils(HmacAlgorithms.HMAC_SHA_1, APP_TOKEN).hmacHex(loginResp.result.challenge);
            FreeboxResponse authorizeResponse = freeboxResource.session(new SessionRequest(APP_ID, hex));
            sessionToken = authorizeResponse.result.sessionToken;
        }
        return sessionToken;
    }
}
