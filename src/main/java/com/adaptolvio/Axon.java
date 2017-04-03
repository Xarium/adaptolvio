package com.adaptolvio;

public class Axon {
    /** The posizion of the axon in the gene. */
    public int genePosition;

    /** The weight/multiplayer of the transmitted signal. */
    public float weight;

    /** The recipients of the transiting signal. */
    private Neuron neuron;

    public Axon(int genePosition, Neuron neuron, float weight) {
        this.genePosition = genePosition;
        this.neuron = neuron;
        this.weight = weight;
    }
}
