package exhibitmanagement.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * Created by Bonga on 4/1/2016.
 */

@Entity
public class Ballistic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String reference;
    private String name;
    private String type;


    public Ballistic ()
    {

    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }

    public String getType() {
        return type;
    }

    public Ballistic(Builder builder) {

        id = builder.id;
        name = builder.name;
        reference = builder.reference;
        type = builder.type;

    }


    public static class Builder {

        //Equivalent to setters
        private long id;
        private String name;
        private String reference;
        private String type;


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder reference(String reference) {
            this.reference = reference;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }


        public Builder copy(Ballistic ballistic) {
            this.id = ballistic.getId();
            this.name = ballistic.getName();
            this.reference = ballistic.getReference();
            this.type = ballistic.getType();
            return this;
        }

        public Ballistic build() {
            return new Ballistic(this);
        }
    }

}