package com.adaptolvio;

import com.adaptolvio.neurons.ReadNeuron;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NeuronIntegrationTest {

    @Test
    public void decodeFromCleanString() throws Exception {
        // mvn test

        // Each Neuron is define by the following DNA sequences:
        // Type:          [0-f]{1}
        // Axons:
        //  Connected to: [0-f]{2}
        //  Weight:       [0-f]{4}

        String dna = "102ffa500bfa0";
        // 1         Neuron of type HardLimitNeuron
        // 02.ffa5   Connected to neuron with index 2 (not exists)
        // 00.bfa0   Connected to neuron with index 0

        Brain brain = new Brain(dna);
        Neuron neuron = brain.getNeuron(0);

        // It should be an instance of a child class
        Assert.assertEquals("com.adaptolvio.neurons.HardLimitNeuron", neuron.getClass().getCanonicalName());

        // It should have the right number of axons
        Assert.assertEquals(1, neuron.axons.size());
    }

    @Test
    public void readInteraction() {
        // ReadNeuron
        //  4 = ReadNeuron
        //  02.ffa5   Connected to neuron with index 2 (not exists)
        //  01.bfa0   Connected to neuron with index 1

        // LinearNeuron
        //  2 = LinearNeuron

        String dna = "402ffa501bfa0z2";
        Brain brain = new Brain(dna);

        // ReadNeuron
        Neuron a = brain.getNeuron(0);
        // LinearNeuron
        Neuron b = brain.getNeuron(1);

        a.addInput(-999);
        b.addInput(13);
        a.propagate();
        b.propagate();

        // Now the reading is blocked; the value shouldn't change.
        a.addInput(-999);
        b.addInput(215);
        a.propagate();
        b.propagate();  // Calculate Read blocking

        Assert.assertEquals("Fail on reading block", 13, b.input, 0.1);
    }
}