package com.adaptolvio.neurons;

import com.adaptolvio.Axon;
import com.adaptolvio.Neuron;

public class SinNeuron extends Neuron {
    public SinNeuron(String gene) {
        super(gene);
    }

    public double activationFunction() {
        return Math.sin(this.input);
    }

    @Override
    protected void sendSignal() {
        double value = this.activationFunction();
        for (Axon axon: this.axons) {
            axon.neuron.addInput(value);
        }
    }
}
