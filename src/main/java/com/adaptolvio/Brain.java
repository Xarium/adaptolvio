package com.adaptolvio;

import java.util.ArrayList;
import java.util.List;

public class Brain {
    public List<Neuron> neurons = new ArrayList<Neuron>();

    public Neuron getNeuronByIndex(int index) {
        if (index >= neurons.size()) {
            return null;
        }
        return neurons.get(index);
    }

    public void addNeuron(Neuron n) {
        this.neurons.add(n);
    }

    public void connectNeurons() {
        for (Neuron n: this.neurons) {
            n.initializeAxons(this);
        }
    }
}
