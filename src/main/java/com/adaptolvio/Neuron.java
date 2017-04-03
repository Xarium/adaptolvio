package com.adaptolvio;


import com.adaptolvio.neurons.HardLimitNeuron;

import java.util.ArrayList;
import java.util.List;

public abstract class Neuron {
    /**  */
    public String gene;

    /**  */
    protected double input;

    /**  */
    public double value;

    /** Outbound axons. */
    public List<Axon> axons = new ArrayList<Axon>();

    /**  */
    protected int read;

    /**  */
    protected int write;

    public Neuron(String gene) {
        this.gene = gene;
    }

    /**
     * All the Neurons have to be initialized, otherwise the axons could be unable to link to them.
     */
    public void initializeAxons(Brain brain) {
        int startAt = 1;
        while(startAt < this.gene.length()) {
            this.addAxon(startAt, this.gene.substring(startAt, startAt + 6), brain);
            startAt += 6;
        }
    }

    private void addAxon(int genePosition, String axonGene, Brain brain) {
        int destinationIndex = Integer.parseInt(axonGene.substring(0, 2), 16);
        Neuron destination = brain.getNeuronByIndex(destinationIndex);
        if (destination == null) {
            // The Neuron does not exists.
            //  NB: "this.initializeAxons()" have to be executed before of this.
            return;
        }
        float weight = (Integer.parseInt(axonGene.substring(2, 6), 16) - 32768) / 256;  // [16^2; -16^2]

        this.axons.add(new Axon(genePosition, destination, weight));
    }

    public void addRead(boolean $allow) {

    }

    public void addWrite(boolean $allow) {

    }

    public void addValue(boolean $allow) {

    }

    protected abstract double getActivationFunctionResult();

    public void applyActivationFunction() {
        this.value = this.getActivationFunctionResult();
        this.input = 0;
    }

    /**
     *
     * @param gene A string of 3 element, the first is always zero
     * @return
     */
    public static Neuron decodeFromString(String gene) {

        Neuron n;
        switch (gene.charAt(0)) {
            case '1':
                n = new HardLimitNeuron(gene);
                break;
            default:
                n = null;
                break;
        }
        return n;
    }
}
