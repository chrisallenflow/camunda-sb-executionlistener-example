package org.camunda.examples;

import org.camunda.bpm.application.impl.event.ProcessApplicationEventParseListener;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.impl.pvm.process.ActivityImpl;
import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.impl.util.xml.Element;

public class MyParseListener extends ProcessApplicationEventParseListener {

    @Override
    public void parseStartEvent(Element startEventElement, ScopeImpl scope, ActivityImpl startEventActivity) {

        //startEventActivity.addExecutionListener(ExecutionListener.EVENTNAME_END, new MyExecutionListener());
        startEventActivity.addListener(ExecutionListener.EVENTNAME_END, new MyExecutionListener());

    }

}
