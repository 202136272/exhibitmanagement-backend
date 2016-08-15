package exhibitmanagement.domain;

import java.io.Serializable;

/**
 * Created by Bonga on 8/15/2016.
 */
public class Scientific implements Serializable {

    private long id;
    private String name;
    private String mass;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMass() {
        return mass;
    }

    public Scientific(Builder builder) {
        id = builder.id;
        name = builder.name;
        mass = builder.mass;
    }

    public static class Builder {
        //Equivalent to setters
        private long id;
        private String name;
        private String mass;


        public Builder id(long id) {
            this.id= id; //compalsury
            return this;
        }
        public Builder name(String name) {
            this.name= name; //compalsury
            return this;
        }
        public Builder mass(String mass) {
            this.mass = mass;
            return this;
        }
        public Builder copy(Scientific scientific){
            this.name = scientific.getName();
            this.mass = scientific.getMass();

            return this;
        }
        public Scientific build() {
            return new Scientific(this);
        }
    }
}
