package exhibitmanagement.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Entity;
/**
 * Created by Bonga on 4/2/2016.
 */
@Entity
public class Administrator implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private  String persalNumber;
    private  String name;
    private String surname;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPersalNumber() {
        return persalNumber;
    }

    private Administrator()
    {

    }

    public Administrator(Builder builder) {
        id = builder.id;
        name = builder.name;
        surname = builder.surname;
        persalNumber = builder.persalNumber;

    }
    public static class Builder {
        //Equivalent to setters
        private long id;
        private String name;
        private String surname;
        private String persalNumber;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name; //compulsary
            return this;
        }
        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder persalNumber(String persalNumber) {
            this.persalNumber = persalNumber;
            return this;
        }

        public Builder copy(Administrator administrator){
            this.id = administrator.getId();
            this.name = administrator.getName();
            this.surname = administrator.getSurname();
            this.persalNumber = administrator.getPersalNumber();

            return this;
        }
        public Administrator build() {
            return new Administrator(this);
        }
    }

    public String toString()
    {
        return String.format("Id : %d\nName :%s\nSurname :%s\nPersalNumber :%s",id,name,surname,persalNumber);
    }
}
