package com.github.icelyframework.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Help.Ansi;
import picocli.CommandLine.Option;

@Command(name = "generate", description = "",
        mixinStandardHelpOptions = true)
final public class GenerateCommand implements Runnable{
    @Option(names = {"--verbose"}, description = "Print verbose output.")
    boolean verbose;

    @Override
    public void run() {
        if (verbose) {
        }
    }
}
