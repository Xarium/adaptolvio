package com.adaptolvio;


import com.adaptolvio.neurons.HardLimitNeuron;

import java.util.ArrayList;
import java.util.List;

public abstract class Neuron {
    /**  */
    public String gene;

    /**  */
    protected float input;

    /**  */
    public float value;

    /** Outbound axons. */
    public List<Axon> axons = new ArrayList<Axon>();;

    /**  */
    protected int read;

    /**  */
    protected int write;

    public Neuron(String gene) {
        this.gene = gene;
        String weightString = gene.substring(0, 3);

        int i = 3;
        while(i < gene.length()) {
            this.addAxon(i, gene.substring(i, i + 3));
        }
    }

    private void addAxon(int i, String substring) {
        // Parse the string to an Axon object.
    }

    public void addRead(boolean $allow) {

    }

    public void addWrite(boolean $allow) {

    }

    public void addValue(boolean $allow) {

    }

    protected abstract float getActivationFunctionResult();

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

        switch (gene.charAt(0)) {
            case '1':
                return new HardLimitNeuron(gene);
            default:
                return null;
        }
    }
}
