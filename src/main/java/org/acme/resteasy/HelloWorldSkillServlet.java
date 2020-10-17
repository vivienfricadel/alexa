/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package org.acme.resteasy;

import javax.servlet.annotation.WebServlet;

import org.acme.resteasy.handlers.CancelandStopIntentHandler;
import org.acme.resteasy.handlers.HelloWorldIntentHandler;
import org.acme.resteasy.handlers.HelpIntentHandler;
import org.acme.resteasy.handlers.LaunchRequestHandler;
import org.acme.resteasy.handlers.SessionEndedRequestHandler;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.servlet.SkillServlet;

@WebServlet( //
        name = "HelloWorldSkillServlet", //
        description = "Example Servlet Using Annotations", //
        urlPatterns = { "/main" } //
)
public class HelloWorldSkillServlet extends SkillServlet {

    private static final long serialVersionUID = 6072585677018227752L;

    public HelloWorldSkillServlet() {
        super(getSkill());
    }

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(new CancelandStopIntentHandler(), new HelloWorldIntentHandler(), new HelpIntentHandler(), new LaunchRequestHandler(), new SessionEndedRequestHandler())
                // Add your skill id below
                // .withSkillId("")
                .build();
    }

}
