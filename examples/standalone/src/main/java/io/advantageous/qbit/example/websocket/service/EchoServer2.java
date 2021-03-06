package io.advantageous.qbit.example.websocket.service;

import io.advantageous.qbit.admin.ManagedServiceBuilder;

public class EchoServer2 {

    public static void main(final String... args) {
        final ManagedServiceBuilder managedServiceBuilder =
                ManagedServiceBuilder.managedServiceBuilder().setRootURI("/").setPort(9090);

        managedServiceBuilder.getAdminBuilder().setPort(6666);

        /* Start the service. */
        managedServiceBuilder.addEndpointService(new EchoService())
                .getEndpointServerBuilder()
                .build().startServer();

        /* Start the admin builder which exposes health end-points and meta data. */
        managedServiceBuilder.getAdminBuilder().build().startServer();

        System.out.println("Server 2 started");

        managedServiceBuilder.getSystemManager().waitForShutdown();


    }

}
