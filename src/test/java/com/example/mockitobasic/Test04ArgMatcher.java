package com.example.mockitobasic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Test04ArgMatcher {

    @Mock
    List<String> stringList;

    @Test
    public void testMultipleReturns() {
        when(stringList.size()).thenReturn(0).thenReturn(2);
        assertEquals(0, stringList.size());
        assertEquals(2, stringList.size());
    }

    @Test
    public void testSpecificArg() {
        when(stringList.get(0)).thenReturn("Test!");
        assertEquals("Test!", stringList.get(0));
        assertNull(stringList.get(1));
        assertNull(stringList.get(2));
    }

    @Test
    public void testGeneralArg() {
        when(stringList.get(anyInt())).thenReturn("Test!");
        assertEquals("Test!", stringList.get(0));
        assertEquals("Test!", stringList.get(1));
        assertEquals("Test!", stringList.get(2));
    }


}
