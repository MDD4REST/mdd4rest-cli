package com.github.icelyframework.cli;

import com.github.icelyframework.generator.mde.runner.OutputGenerator;
import org.apache.commons.io.FilenameUtils;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import picocli.CommandLine.Help.Ansi;
import picocli.CommandLine.Option;

import java.io.File;

@Command(name = "transform", description = "",
        mixinStandardHelpOptions = true)
final public class TransformCommand implements Runnable{
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
        String yamlPath = "";

        if (inputOptimized){
            yamlPath = currentDirectory + "/CIM/yaml/" + projectName + "-optimized.yaml";
        }else {
            yamlPath = currentDirectory + "/CIM/yaml/" + projectName + ".yaml";
        }

        if(action.equalsIgnoreCase("CIM2PIM")){
            OutputGenerator outputGenerator = new OutputGenerator(projectName,projectPath);
            outputGenerator.pimGenerator(yamlPath);
        }

        if (verbose) {
        }
    }
}
