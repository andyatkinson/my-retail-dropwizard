package com.andyatkinson;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MyRetailApplication extends Application<MyRetailConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MyRetailApplication().run(args);
    }

    @Override
    public String getName() {
        return "MyRetail";
    }

    @Override
    public void initialize(final Bootstrap<MyRetailConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final MyRetailConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
