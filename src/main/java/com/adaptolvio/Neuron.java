package com.adaptolvio;


import com.adaptolvio.neurons.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Neuron {
    /**  */
    public String gene;

    /**  */
    public double input;

    /** Outbound axons. */
    public List<Axon> axons = new ArrayList<Axon>();

    /**  */
    public double read;

    /**  */
    public double inputRead;

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
        while(startAt < this.gene.length()-1) {
            this.addAxon(startAt, this.gene.substring(startAt, startAt + 6), brain);
            startAt += 6;
        }
    }

    private void addAxon(int genePosition, String axonGene, Brain brain) {
        int destinationIndex = Integer.parseInt(axonGene.substring(0, 2), 16);
        Neuron destination = brain.getNeuron(destinationIndex);
        if (destination == null) {
            // The Neuron does not exists.
            //  NB: "this.initializeAxons()" have to be executed before of this.
            return;
        }
        float weight = (Integer.parseInt(axonGene.substring(2, 6), 16) - 32768) / 256;  // [16^2; -16^2]

        this.axons.add(new Axon(genePosition, destination, weight));
    }

    /**
     *
     * @param allow Allowed values: +1 or -1
     */
    public void addRead(double allow) {
        System.out.println(this.getClass().getCanonicalName() + " read " + allow);
        this.inputRead += allow;
    }

    /**
     *
     * @param allow Allowed values: +1 or -1
     */
    public void addWrite(int allow) {
        System.out.println(this.getClass().getCanonicalName() + " write " + allow);
        this.write += allow;
    }

    /**
     * Accept new values on input only if the Neuron isn't blocked on reading
     * @param input
     */
    public void addInput(double input) {
        if (this.read >= 0) {
            System.out.println(this.getClass().getCanonicalName() + " input " + input);
            this.input += input;
        }
    }

    protected abstract void sendSignal();

    public void propagate() {
        // Invia il segnale solo se non è attivo il blocco di propagazione della memoria
        if (this.write >= 0) {
            this.sendSignal();
        }

        this.read = this.inputRead;
        this.inputRead = 0;

        // resetta la lettura solo se non deve mantenere in memoria il valore
        if (this.read >= 0) {
            System.out.println("adfgdfgafgsrgsgsfdgdsfgsfdgs");
            this.input = 0;
        }
        this.write = 0;
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
            case '2':
                n = new LinearNeuron(gene);
                break;
            case '3':
                n = new SinNeuron(gene);
                break;
            case '4':
                n = new ReadNeuron(gene);
                break;
            case '5':
                n = new WriteNeuron(gene);
                break;
            default:
                n = null;
                break;
        }
        return n;
    }
}
