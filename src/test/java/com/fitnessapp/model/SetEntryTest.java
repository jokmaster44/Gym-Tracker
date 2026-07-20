package com.fitnessapp.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for SetEntry.
 *
 * These tests verify that:
 * - set volume is calculated correctly
 */
public class SetEntryTest {

    /**
     * Testcase: Should calculate set volume.
     *
     * Steps:
     * 1. Create set entry with weight 70 and 10 reps.
     * 2. Call getVolume().
     *
     * Result state:
     * - Returned volume is 700.
     */
    @Test
    void testGetVolume_should_return_weight_multiplied_by_reps() {

        // Arrange
        SetEntry set = new SetEntry(70, 10);

        // Act
        double volume = set.getVolume();

        // Assert
        assertEquals(700, volume);
    }

    /**
     * Testcase: Should return readable set text.
     *
     * Steps:
     * 1. Create set entry with weight 70 and 10 reps.
     * 2. Call toString().
     *
     * Result state:
     * - Returned text is "70.0 kg x 10".
     */
    @Test
    void testToString_should_return_readable_set_text() {

        // Arrange
        SetEntry set = new SetEntry(70, 10);

        // Act
        String text = set.toString();

        // Assert
        assertEquals("70.0 kg x 10", text);
    }
}
