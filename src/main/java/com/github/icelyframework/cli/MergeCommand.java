package com.github.icelyframework.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Help.Ansi;
import picocli.CommandLine.Option;

@Command(name = "merge", description = "",
        mixinStandardHelpOptions = true)
final public class MergeCommand implements Runnable {
    @Option(names = {"--verbose"}, description = "Print verbose output.")
    boolean verbose;

    @Override
    public void run() {
        if (verbose) {
        }
    }
}
