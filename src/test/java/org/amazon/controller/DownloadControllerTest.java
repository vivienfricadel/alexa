package org.amazon.controller;

import javax.inject.Inject;

import org.amazon.freebox.controller.FreeboxController;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class DownloadControllerTest {

    @Inject
    FreeboxController freeboxController;

    @Test
    public void testSession() {
        freeboxController.addDownloadUrl("https://vww.cpasbien.ph/get_torrent/2e1fc4630f8f4b7e0d7858c21fe54ad9f7e65594");
    }
}
