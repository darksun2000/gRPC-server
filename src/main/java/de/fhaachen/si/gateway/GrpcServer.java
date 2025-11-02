package de.fhaachen.si.gateway;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
    public static void main(String[] args) throws Exception {

        StockConfig sc = new StockConfig();
        StockService stockService = new StockService(sc);

        Server server = ServerBuilder.forPort(9090)
                .addService(stockService)
                .build()
                .start();

        System.out.println("✅ gRPC Server started on port 9090");
        server.awaitTermination();
    }
}
