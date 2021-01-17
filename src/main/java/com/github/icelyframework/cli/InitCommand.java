package com.github.icelyframework.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Help.Ansi;
import picocli.CommandLine.Option;

import java.io.File;
import java.io.IOException;


@Command(name = "init", description = "Initilize a Project",
        mixinStandardHelpOptions = true)
final public class InitCommand implements Runnable{

    @Option(names = {"--verbose"}, description = "Print verbose output.")
    boolean verbose;

    @Override
    public void run() {
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("The current working directory is " + currentDirectory);
        // generate directories
        File cimDir = new File(currentDirectory + "/CIM");
        File cimActStormDir = new File(currentDirectory + "/CIM/activity storming");
        File cimOntologyDir = new File(currentDirectory + "/CIM/ontology");
        File cimYamlDir = new File(currentDirectory + "/CIM/yaml");
        File pimDir = new File(currentDirectory + "/PIM");
        File psmDir = new File(currentDirectory + "/PSM");
        File psmAbstractDir = new File(currentDirectory + "/PSM/abstract");
        File psmGDSLDir = new File(currentDirectory + "/PSM/generators dsl");
        File psmGModelDir = new File(currentDirectory + "/PSM/generators model");
        File codeDir = new File(currentDirectory + "/Code");

        if (!cimDir.exists()) cimDir.mkdirs();
        if (!cimActStormDir.exists()) cimActStormDir.mkdirs();
        if (!cimOntologyDir.exists()) cimOntologyDir.mkdirs();
        if (!cimYamlDir.exists()) cimYamlDir.mkdirs();
        if (!pimDir.exists()) pimDir.mkdirs();
        if (!psmDir.exists()) psmDir.mkdirs();
        if (!psmAbstractDir.exists()) psmAbstractDir.mkdirs();
        if (!psmGDSLDir.exists()) psmGDSLDir.mkdirs();
        if (!psmGModelDir.exists()) psmGModelDir.mkdirs();
        if (!codeDir.exists()) codeDir.mkdirs();

        // generate icely file
        File icelyConfig = new File(currentDirectory + "/.icely");
        try {
            if (!icelyConfig.exists()) icelyConfig.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if (verbose) {
        }
    }
}
