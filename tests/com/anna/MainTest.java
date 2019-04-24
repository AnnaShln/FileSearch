package com.anna;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void main() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PrintStream old = System.out;
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        String [] args={"-d Grandmother", "Mother"};

        Main.main(args);

        System.out.flush();
        System.setOut(old);
        System.out.println("+"+baos.toString());

    }

    @Test
    void fileSearch() {
        Main example = new Main();
        String actual = example.fileSearch("Mother.txt","src\\com\\anna\\Grandmother", false);
        assertEquals("C:\\Users\\Анна_2\\IdeaProjects\\SearchFile\\src\\com\\anna\\Grandmother\\Mother.txt", actual);
    }

    @Test
    void fileSearch_NoFile() {
        Main example = new Main();
        String actual = example.fileSearch("Neighbour.txt","src\\com\\anna\\Grandmother", false);
        assertEquals("Файл не найден", actual);
    }

    @Test
    void fileSearch_SubSearch() {
        Main example = new Main();
        String actual = example.fileSearch("Son.txt","src\\com\\anna\\Grandmother", true);
        assertEquals("C:\\Users\\Анна_2\\IdeaProjects\\SearchFile\\src\\com\\anna\\Grandmother\\Father\\Son.txt", actual);
    }

    @Test
    void fileSearch_SubSearch2() {
        Main example = new Main();
        String actual = example.fileSearch("Aunt.txt","src\\com\\anna\\Grandmother", true);
        assertEquals("C:\\Users\\Анна_2\\IdeaProjects\\SearchFile\\src\\com\\anna\\Grandmother\\Aunt.txt", actual);
    }

    @Test
    void fileSearch_SubSearch3() {
        Main example = new Main();
        String actual = example.fileSearch("Cousin.txt","src\\com\\anna\\Grandmother", true);
        assertEquals("C:\\Users\\Анна_2\\IdeaProjects\\SearchFile\\src\\com\\anna\\Grandmother\\Uncle\\Cousin.txt", actual);
    }

    @Test
    void fileSearch_NoDir() {
        Main example = new Main();
        String actual = example.fileSearch("Mother.txt","src\\com\\anna\\Grandfather", true);
        assertEquals("Файл не найден", actual);
    }
}