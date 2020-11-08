package org.amazon.controller;

import javax.inject.Inject;

import org.amazon.download.controller.DownloadController;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class FreeboxControllerTest {

    @Inject
    DownloadController downloadController;

    @Test
    public void testSearch() {

        downloadController.search("joker");
    }

}
