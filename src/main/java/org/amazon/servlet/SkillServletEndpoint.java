/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package org.amazon.servlet;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

import org.amazon.download.controller.DownloadController;
import org.amazon.freebox.controller.FreeboxController;
import org.amazon.handler.custom.CommandIntentHandler;
import org.amazon.handler.custom.DownloadIntentHandler;
import org.amazon.handler.custom.ListIntentHandler;
import org.amazon.handler.required.CancelandStopIntentHandler;
import org.amazon.handler.required.HelpIntentHandler;
import org.amazon.handler.required.LaunchRequestHandler;
import org.amazon.handler.required.SessionEndedRequestHandler;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.servlet.SkillServlet;

@WebServlet( //
        name = "HelloWorldSkillServlet", //
        description = "Example Servlet Using Annotations", //
        urlPatterns = { "/main" } //
)
public class SkillServletEndpoint extends SkillServlet {

    @Inject
    FreeboxController freeboxController;

    private static final long serialVersionUID = 6072585677018227752L;

    public SkillServletEndpoint(FreeboxController freeboxController, DownloadController downloadController) {
        super(getSkill(freeboxController, downloadController));
    }

    @SuppressWarnings("unchecked")
    private static Skill getSkill(FreeboxController freeboxController, DownloadController downloadController) {
        return Skills.standard().addRequestHandlers( //
                new CancelandStopIntentHandler(), //
                new ListIntentHandler(), //
                new CommandIntentHandler(), //
                new DownloadIntentHandler(freeboxController, downloadController), //
                new HelpIntentHandler(), //
                new LaunchRequestHandler(), //
                new SessionEndedRequestHandler()) //
                // Add your skill id below
                .withSkillId("amzn1.ask.skill.5742c2f6-17e4-4b9b-9fce-d03592614400").build();
    }

}
