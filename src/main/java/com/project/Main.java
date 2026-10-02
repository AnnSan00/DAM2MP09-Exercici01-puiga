package com.project;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        try {

            CompletableFuture<Void> proces =
                    CompletableFuture
                            .supplyAsync(() -> {

                                System.out.println(
                                        "Validant dades de la sol·licitud...");

                                return 100;

                            }, executor)

                            .thenApply(valor -> {

                                System.out.println(
                                        "Processant dades...");

                                return valor + 50;

                            })

                            .thenAccept(resultat -> {

                                System.out.println(
                                        "Resposta final enviada a l'usuari: "
                                                + resultat);
                            });

            proces.join();

        } finally {
            executor.shutdown();
        }
    }
}           