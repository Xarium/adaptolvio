package com.adaptolvio;

import com.adaptolvio.neurons.HardLimitNeuron;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marco.favin on 22/03/17.
 */
public class NeuronTest {
    @Test
    public void addRead() throws Exception {

    }

    @Test
    public void addWrite() throws Exception {

    }

    @Test
    public void addValue() throws Exception {

    }

    @Test
    public void applyActivationFunction() throws Exception {

    }

    @Test
    public void decodeFromString() throws Exception {
        Neuron neuron = Neuron.decodeFromString("1f7");

        // It should be an instance of a child class
        Assert.assertEquals("com.adaptolvio.neurons.HardLimitNeuron", neuron.getClass().getCanonicalName());

        // It should have the right number of axons
        Assert.assertEquals(2, neuron.axons.size());
    }

}