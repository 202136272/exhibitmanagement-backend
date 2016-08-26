package exhibitmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Bonga on 8/14/2016.
 */
@Entity
public class InvestigatingOfficer implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String persalNumber;
    private String name;
    private String rank;
    private String station;

    private InvestigatingOfficer()
    {

    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getStation() {
        return station;
    }

    public String getPersalNumber() {
        return persalNumber;
    }

    public Long getId() {
        return id;
    }

    public InvestigatingOfficer(Builder builder) {
        id = builder.id;
        name = builder.name;
        rank = builder.rank;
        station = builder.station;
        persalNumber = builder.persalNumber;

    }


    public static class Builder {
        //Equivalent to setters
        private long id;
        private String name;
        private String rank;
        private String station;
        private String persalNumber;


        public Builder id(Long id) {
            this.id= id; //compalsury
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder rank(String rank) {
            this.rank = rank;
            return this;
        }

        public Builder station(String station) {
            this.station = station;
            return this;
        }


        public Builder persalNumber(String persalNumber) {
            this.persalNumber = persalNumber;
            return this;
        }
        public Builder copy(InvestigatingOfficer investigatingOfficer){
            this.id = investigatingOfficer.getId();
            this.name = investigatingOfficer.getName();
            this.rank = investigatingOfficer.getRank();
            this.station = investigatingOfficer.getStation();
            this.persalNumber = investigatingOfficer.getPersalNumber();
            return this;
        }
        public InvestigatingOfficer build() {
            return new InvestigatingOfficer(this);
        }
    }

}
