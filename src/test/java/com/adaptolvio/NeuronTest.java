package com.adaptolvio;

import com.adaptolvio.neurons.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NeuronTest {

    @Test
    public void hardLimitNeuron() {
        HardLimitNeuron n = new HardLimitNeuron("");

        n.input = 123;
        Assert.assertEquals("HardLimitNeuron upper value", 1, n.activationFunction(), 0);

        n.input = -23;
        Assert.assertEquals("HardLimitNeuron lower value", -1, n.activationFunction(), 0);
    }

    @Test
    public void linearNeuron() {
        LinearNeuron n = new LinearNeuron("");

        n.input = -10;
        Assert.assertEquals("LinearNeuron output expected to be equal to its input", -10, n.activationFunction(), 0);

        n.input = 0;
        Assert.assertEquals("LinearNeuron output expected to be equal to its input", 0, n.activationFunction(), 0);

        n.input = +10;
        Assert.assertEquals("LinearNeuron output expected to be equal to its input", +10, n.activationFunction(), 0);
    }

    @Test
    public void sinNeuron() {
        SinNeuron n = new SinNeuron("");

        n.input = Math.toRadians(0);
        Assert.assertEquals("SinNeuron output expected to be sinusoidal", 0, n.activationFunction(), 0.01);

        n.input = Math.toRadians(90);
        Assert.assertEquals("SinNeuron output expected to be sinusoidal", 1, n.activationFunction(), 0.01);

        n.input = Math.toRadians(180);
        Assert.assertEquals("SinNeuron output expected to be sinusoidal", 0, n.activationFunction(), 0.01);

        n.input = Math.toRadians(270);
        Assert.assertEquals("SinNeuron output expected to be sinusoidal", -1, n.activationFunction(), 0.01);
    }

    @Test
    public void readNeuron() {
        ReadNeuron n = new ReadNeuron("");

        n.input = 123;
        Assert.assertEquals("HardLimitNeuron upper value", 1, n.activationFunction(), 0);

        n.input = -23;
        Assert.assertEquals("HardLimitNeuron lower value", -1, n.activationFunction(), 0);
    }

    @Test
    public void writeNeuron() {
        WriteNeuron n = new WriteNeuron("");

        n.input = 123;
        Assert.assertEquals("HardLimitNeuron upper value", 1, n.activationFunction(), 0);

        n.input = -23;
        Assert.assertEquals("HardLimitNeuron lower value", -1, n.activationFunction(), 0);
    }

}