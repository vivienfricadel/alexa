/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package org.amazon.handler.custom;

import static com.amazon.ask.request.Predicates.intentName;

import java.awt.Desktop;
import java.net.URI;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

public class CommandIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("Command"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        Slot numberSlot = ((IntentRequest) input.getRequest()).getIntent().getSlots().get("number");

        int commandNumber = 0;
        try {
            commandNumber = Integer.parseInt(numberSlot.getValue());
        } catch (NumberFormatException e) {
            // TODO: handle exception
        }

        switch (commandNumber) {
        case 1:
            try {
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=tIvLOADogNk&ab_channel=Oliech"));
            } catch (Exception e) {
                // TODO
            }
            break;
        case 2:
            try {
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/c/oliechGaming/videos"));
            } catch (Exception e) {
                // TODO
            }
            break;
        case 3:
            try {
                Desktop.getDesktop().browse(new URI("https://www.cnews.fr/emission/2020-10-15/face-linfo-du-15102020-1008407"));
            } catch (Exception e) {
                // TODO
            }
            break;
        case 4:
            try {
                Desktop.getDesktop().browse(new URI("https://www.twitch.tv/solaryhs"));
            } catch (Exception e) {
                // TODO
            }
            break;
        case 1000:
            try {
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=tIvLOADogNk&ab_channel=Oliech"));
            } catch (Exception e) {
                // TODO
            }
            break;

        default:
            break;
        }

        String speechText = "Commande " + numberSlot.getValue();
        return input.getResponseBuilder() //
                .withSpeech(speechText) //
                .withSimpleCard("Command", speechText) //
                .withReprompt("Numero de commande").build();
    }

}
