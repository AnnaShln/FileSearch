package com.anna;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void fileSearch() {
        String actual = Main.fileSearch("Mother.txt","tests\\resources\\Grandmother", false);
        assertEquals("tests\\resources\\Grandmother\\Mother.txt", actual);
    }

    @Test
    void fileSearch_NoFile() {
        String actual = Main.fileSearch("Neighbour.txt","tests\\resources\\Grandmother", false);
        assertEquals("Файл не найден", actual);
    }

    @Test
    void fileSearch_SubSearch() {
        String actual = Main.fileSearch("Son.txt","tests\\resources\\Grandmother", true);
        assertEquals("tests\\resources\\Grandmother\\Father\\Son.txt", actual);

    }

    @Test
    void fileSearch_SubSearch2() {
        String actual = Main.fileSearch("Aunt.txt","tests\\resources\\Grandmother", true);
        assertEquals("tests\\resources\\Grandmother\\Aunt.txt", actual);
    }

    @Test
    void fileSearch_SubSearch3() {
        String actual = Main.fileSearch("Cousin.txt","tests\\resources\\Grandmother", true);
        assertEquals("tests\\resources\\Grandmother\\Uncle\\Cousin.txt", actual);
    }

    @Test
    void fileSearch_NoDir() {
        String actual = Main.fileSearch("Mother.txt","tests\\resources\\Grandfather", true);
        assertEquals("Файл не найден", actual);
    }
}