package com.adaptolvio;

import java.util.ArrayList;
import java.util.List;

public class Brain {
    protected List<Neuron> neurons = new ArrayList<Neuron>();

    protected String dna;

    public Brain(String dna) {
        this.dna = dna;

        // Split dna sequence in array o pieces each one describing a Neuron
        String[] genes = dna.split("z");
        for (String gene : genes) {

            // Add the neuron if the sequence is valid
            Neuron neuron = Neuron.decodeFromString(gene);
            if (neuron != null) {
                this.neurons.add(neuron);
            }
        }
        this.connectNeurons();
    }

    public Neuron getNeuron(int index) {
        if (index >= neurons.size()) {
            return null;
        }
        return neurons.get(index);
    }

    protected void connectNeurons() {
        for (Neuron n: this.neurons) {
            n.initializeAxons(this);
        }
    }
}
