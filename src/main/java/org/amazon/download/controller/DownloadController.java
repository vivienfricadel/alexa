package org.amazon.download.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class DownloadController {

    private static final Logger LOG = LoggerFactory.getLogger(DownloadController.class);

    public DownloadModel search(String search) {

        List<DownloadModel> downloadModels = new ArrayList<>();

        try {
            Document doc = Jsoup.connect("https://wvw.cpasbien.ph/recherche/" + search).get();
            Elements elements = doc.select(".table-corps td");
            for (Element element : elements) {
                String title = element.select("a").first().text();
                String url = element.select("a").first().attr("abs:href");
                int up = Integer.parseInt(element.select(".seed_ok").first().text());

                downloadModels.add(new DownloadModel(title, url, up));

            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }

        Collections.sort(downloadModels);

        try {
            DownloadModel downloadModel = downloadModels.get(0);


            Document doc = Jsoup.connect(downloadModels.get(0).url).get();
            Elements elements = doc.select(".btn-download a");
            for (Element element : elements) {
                String url = element.attr("abs:href");

                downloadModel.torrentUrl = url;

                LOG.info(downloadModel.toString());
                return downloadModel;
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }
}
