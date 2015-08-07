package by.prohorov.subject;

import java.io.Serializable;

/**
 * Created by Vaio on 03.08.15.
 */
public abstract class Entity implements Serializable, Cloneable{
    private int id;


    public Entity() {
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
