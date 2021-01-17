package com.github.icelyframework.cli;

import org.apache.commons.io.FilenameUtils;
import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import picocli.CommandLine.Help.Ansi;
import picocli.CommandLine.Option;
import com.github.icelyframework.generator.ontology.runner.OutputGenerator;

import java.io.File;

@Command(name = "ontology", description = "",
        mixinStandardHelpOptions = true)
final public class OntologyCommand implements Runnable{
    @Option(names = {"--verbose"}, description = "Print verbose output.")
    boolean verbose;
    @Option(names = {"-iO"}, description = "Input Optimized")
    boolean inputOptimized;
    @Option(names = {"-oO"}, description = "Output Optimized")
    boolean outputOptimized;
    @Parameters(arity = "1..1", description = "required one action")
    String action;

    @Override
    public void run() {
        String currentDirectory = System.getProperty("user.dir");
        currentDirectory = FilenameUtils.separatorsToUnix(currentDirectory);
        File currentDirectoryFile = new File(currentDirectory);
        String projectPath = currentDirectory;
        String projectName = currentDirectoryFile.getName();
        System.out.println(projectName);
        System.out.println(projectPath);

        OutputGenerator outputGenerator = new OutputGenerator(projectName, projectPath);

        if(action.equalsIgnoreCase("dynamic")){
            outputGenerator.dynamicOntologyGenerator();
        }

        if(action.equalsIgnoreCase("linked")){
            outputGenerator.linkedOntolotyGenerator();
        }

        if(action.equalsIgnoreCase("yaml")){
            outputGenerator.yamlGenerator();
        }
        if (verbose) {
        }
    }
}
