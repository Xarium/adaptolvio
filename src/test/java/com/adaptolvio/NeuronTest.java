package com.adaptolvio;

import com.adaptolvio.neurons.HardLimitNeuron;
import com.adaptolvio.neurons.LinearNeuron;
import com.adaptolvio.neurons.SinNeuron;
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

        Brain brain = new Brain();
        Neuron neuron = Neuron.decodeFromString(dna);
        brain.addNeuron(neuron);
        brain.connectNeurons();


        // It should be an instance of a child class
        Assert.assertEquals("com.adaptolvio.neurons.HardLimitNeuron", neuron.getClass().getCanonicalName());

        // It should have the right number of axons
        Assert.assertEquals(1, neuron.axons.size());
    }

    @Test
    public void hardLimitNeuron() {
        Neuron n = new HardLimitNeuron("");

        n.input = 123;
        n.applyActivationFunction();
        Assert.assertEquals("HardLimitNeuron upper value", 1, n.value, 0);

        n.input = -23;
        n.applyActivationFunction();
        Assert.assertEquals("HardLimitNeuron lower value", -1, n.value, 0);
    }

    @Test
    public void linearNeuron() {
        Neuron n = new LinearNeuron("");

        n.input = -10;
        n.applyActivationFunction();
        Assert.assertEquals("LinearNeuron output expected to be equal to its input", -10, n.value, 0);

        n.input = 0;
        n.applyActivationFunction();
        Assert.assertEquals("LinearNeuron output expected to be equal to its input", 0, n.value, 0);

        n.input = +10;
        n.applyActivationFunction();
        Assert.assertEquals("LinearNeuron output expected to be equal to its input", +10, n.value, 0);
    }

    @Test
    public void sinNeuron() {
        Neuron n = new SinNeuron("");

        n.input = 0;
        n.applyActivationFunction();
        Assert.assertEquals("SinNeuron output expected to be sinusoidal", 0, n.value, 0.01);

        n.input = Math.toRadians(90);
        n.applyActivationFunction();
        Assert.assertEquals("SinNeuron output expected to be sinusoidal", 1, n.value, 0.01);

        n.input = Math.toRadians(180);
        n.applyActivationFunction();
        Assert.assertEquals("SinNeuron output expected to be sinusoidal", 0, n.value, 0.01);

        n.input = Math.toRadians(270);
        n.applyActivationFunction();
        Assert.assertEquals("SinNeuron output expected to be sinusoidal", -1, n.value, 0.01);
    }

    @Test
    public void memoryNeurons() {
        // @todo: test read/write neurons
    }

}