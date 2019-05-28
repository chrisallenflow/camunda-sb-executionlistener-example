package org.camunda.examples;

import org.camunda.bpm.engine.impl.bpmn.parser.BpmnParseListener;
import org.camunda.bpm.engine.impl.cfg.AbstractProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.spring.boot.starter.configuration.Ordering;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
@Order(Ordering.DEFAULT_ORDER + 1)
public class MyParseListenerPlugin extends AbstractProcessEnginePlugin {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    @Override
    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {

        LOGGER.info("++ in plugin preinit....");

        // get all existing preParseListeners
        List<BpmnParseListener> preParseListeners = processEngineConfiguration.getCustomPostBPMNParseListeners();

        if (preParseListeners == null) {

            // if no preParseListener exists, create new list
            preParseListeners = new ArrayList<>();

        }

        // add our new custom BPMN Parse Listener
        preParseListeners.add(new MyParseListener());
        processEngineConfiguration.setCustomPostBPMNParseListeners(preParseListeners);

    }

}
