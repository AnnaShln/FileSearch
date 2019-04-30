package com.anna;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;


public class CommandLineArgument {
    public boolean isKeySubDir() {
        return keySubDir;
    }

    public String getKeyDir() {
        return keyDir;
    }

    public String getName() {
        return name;
    }

    @Option(name = "-r", usage = "subdirectory search required")
    private boolean keySubDir;

    @Option(name = "-d", usage = "directory search")
    private String keyDir;

    @Argument()
    private String name;

    public CommandLineArgument(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}