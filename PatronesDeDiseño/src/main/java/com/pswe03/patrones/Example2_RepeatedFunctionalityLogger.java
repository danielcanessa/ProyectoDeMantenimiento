package com.pswe03.patrones;

interface Service {
    void process();

    void validate();
}

class BasicService implements Service {
    @Override
    public void process() {
        // process logic
    }

    @Override
    public void validate() {
        // validation logic
    }
}

abstract class ServiceDecorator implements Service {
    protected final Service decoratedService;

    protected ServiceDecorator(Service decoratedService) {
        this.decoratedService = decoratedService;
    }
}

class LoggingServiceDecorator extends ServiceDecorator {
    LoggingServiceDecorator(Service decoratedService) {
        super(decoratedService);
    }

    @Override
    public void process() {
        executeWithLogging("process", decoratedService::process);
    }

    @Override
    public void validate() {
        executeWithLogging("validate", decoratedService::validate);
    }

    private void executeWithLogging(String operation, Runnable action) {
        System.out.println("Start " + operation);
        action.run();
        System.out.println("End " + operation);
    }
}
