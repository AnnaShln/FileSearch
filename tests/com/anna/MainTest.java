package com.anna;

import org.junit.jupiter.api.Test;

import static java.io.File.separatorChar;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void fileSearch() {
        String actual = Main.fileSearch("Mother.txt","tests"+separatorChar+"resources"+separatorChar+"Grandmother", false);
        assertEquals("tests"+separatorChar+"resources"+separatorChar+"Grandmother"+separatorChar+"Mother.txt", actual);
    }

    @Test
    void fileSearch_NoFile() {
        String actual = Main.fileSearch("Neighbour.txt","tests"+separatorChar+"resources"+separatorChar+"Grandmother", false);
        assertEquals("Файл не найден", actual);
    }

    @Test
    void fileSearch_SubSearch() {
        String actual = Main.fileSearch("Son.txt","tests"+separatorChar+"resources"+separatorChar+"Grandmother", true);
        assertEquals("tests"+separatorChar+"resources"+separatorChar+"Grandmother"+separatorChar+"Father"+separatorChar+"Son.txt", actual);

    }

    @Test
    void fileSearch_SubSearch2() {
        String actual = Main.fileSearch("Aunt.txt","tests"+separatorChar+"resources"+separatorChar+"Grandmother", true);
        assertEquals("tests"+separatorChar+"resources"+separatorChar+"Grandmother"+separatorChar+"Aunt.txt", actual);
    }

    @Test
    void fileSearch_SubSearch3() {
        String actual = Main.fileSearch("Cousin.txt","tests"+separatorChar+"resources"+separatorChar+"Grandmother", true);
        assertEquals("tests"+separatorChar+"resources"+separatorChar+"Grandmother"+separatorChar+"Uncle"+separatorChar+"Cousin.txt", actual);
    }

    @Test
    void fileSearch_NoDir() {
        String actual = Main.fileSearch("Mother.txt","tests"+separatorChar+"resources"+separatorChar+"Grandfather", true);
        assertEquals("Файл не найден", actual);
    }

    @Test
    void fileSearch_Null() {
        String actual = Main.fileSearch(null,"", false);
        assertEquals("Файл не найден", actual);
    }
}