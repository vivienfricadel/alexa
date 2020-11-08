package org.amazon.handler.custom;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import org.amazon.download.controller.DownloadController;
import org.amazon.download.controller.DownloadModel;
import org.amazon.freebox.controller.FreeboxController;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

@ApplicationScoped
public class DownloadIntentHandler implements RequestHandler {

    private FreeboxController freeboxController;
    private DownloadController downloadController;

    public DownloadIntentHandler(FreeboxController freeboxController, DownloadController downloadController) {
        super();
        this.freeboxController = freeboxController;
        this.downloadController = downloadController;
    }

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("Download"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        Slot searchSlot = ((IntentRequest) input.getRequest()).getIntent().getSlots().get("search");
        String search = searchSlot.getValue();

        DownloadModel downloadModel = downloadController.search(search);
        freeboxController.addDownloadUrl(downloadModel.torrentUrl);

        return input.getResponseBuilder() //
                .withSpeech("Télécharger " + search) //
                .withReprompt("Télécharger " + search).build();
    }

}
