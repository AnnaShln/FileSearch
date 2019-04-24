package com.anna;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;


public class CommandLineArgument {
    @Option(name = "-r", usage = "subdirectory search required")
    public boolean keySubDir;

    @Option(name = "-d", usage = "directory search")
    public boolean keyDir;

    @Argument(index = 0)
    public String dir;

    @Argument(index = 1)
    public String name;

    public CommandLineArgument(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}