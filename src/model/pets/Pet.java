package model.pets;

import model.Human;

import java.util.Objects;

public class Pet {
    protected boolean friendly;
    protected boolean needsAttention;
    protected String species;
    protected String color;
    protected double price;

    private Human human;

    public Pet(String species, String color, boolean friendly, boolean needsAttention, double price){
        this(species, color, price);
        this.friendly = friendly;
        this.needsAttention = needsAttention;
    }

    public Pet(String species, String color, double price){
        this.species = species;
        this.color = color;
        this.friendly = true;
        this.needsAttention = false;
        this.price = price;
    }

    //getters
    public String getSpecies() {
        return species;
    }

    public boolean isFriendly() { return friendly; }

    public boolean needsAttention() {
        return needsAttention;
    }

    public double getPrice() {
        return price;
    }

    public Human getHuman() {
        return human;
    }

    //REQUIRES: human != null
    //MODIFIES: this, human
    //EFFECTS: adopts human, and vice versa
    public void adoptHuman(Human human) {
        System.out.println("Adopting a human!");
        if (!human.hasPet(this)) {
            this.human = human;
            human.adoptPet(this);
            System.out.println("Success! Adopted " + human);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return species.equals(pet.species) &&
                color.equals(pet.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, color);
    }

    @Override
    public String toString() {
        return "Pet {" +
                "species='" + species + '\'' +
                ", friendly=" + friendly +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", human= " + human +
                '}';
    }
}
