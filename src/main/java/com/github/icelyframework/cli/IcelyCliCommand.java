package com.github.icelyframework.cli;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import picocli.CommandLine.Command;
import picocli.CommandLine.Help;
import picocli.CommandLine.Option;
import picocli.CommandLine.Spec;
import picocli.CommandLine.Model.CommandSpec;

@Command(
        name = "icely",
        description = "Icely Framework CLI",
        version = {
            "Icely Framework CLI 0.1.0",
            "(c) 2021"
        },
        mixinStandardHelpOptions = true,
        subcommands = {
            InitCommand.class,
            MergeCommand.class,
            TransformCommand.class,
            GenerateCommand.class,
            OntologyCommand.class,
            MigrateCommand.class
        },
        header = {
                "@|blue d8b                  888          |@",
                "@|blue Y8P                  888          |@",
                "@|blue                      888          |@",
                "@|blue 888  .d8888b .d88b.  888 888  888 |@",
                "@|blue 888 d88P\"   d8P  Y8b 888 888  888 |@",
                "@|blue 888 888     88888888 888 888  888 |@",
                "@|blue 888 Y88b.   Y8b.     888 Y88b 888 |@",
                "@|blue 888  \"Y8888P \"Y8888  888  \"Y88888 |@",
                "@|blue                               888 |@",
                "@|blue                          Y8b d88P |@",
                "@|blue                            \"Y88P\" |@",
        }
)
public class IcelyCliCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "verbose operation")
    boolean verbose;

    @Spec CommandSpec spec;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(IcelyCliCommand.class, args);
    }

    public void run() {
        String[] banner = spec.usageMessage().header();

        for (String line : banner) {
            System.out.println(Help.Ansi.AUTO.string(line));
        }

        if (verbose) {
            System.out.println("Hi!");
        }
    }
}
