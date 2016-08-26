package exhibitmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Bonga on 8/13/2016.
 */
@Entity
public class Exhibit  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String casNumber;
    private String sceneType; // ballistic, biology, chemistry, precious metals, questioned doc, scientific
    private String station;
    private String description;

    public long getId() {
        return id;
    }

    public String getCasNumber() {
        return casNumber;
    }

    public String getStation() {
        return station;
    }

    public String getDescription() {
        return description;
    }

    public String getSceneType() {
        return sceneType;
    }

    private Exhibit()
    {

    }

    public Exhibit(Builder builder) {

        id = builder.id;
        casNumber = builder.casNumber;
        station = builder.station;
        description = builder.description;
        sceneType = builder.sceneType;

    }


    public static class Builder {

        //Equivalent to setters
        private long id;
        private String casNumber;
        private String station;
        private String description;
        private String sceneType;

        public Builder id(long id) {
            this.id = id;//compalsury
            return this;
        }

        public Builder casNumber(String casNumber) {
            this.casNumber = casNumber;
            return this;
        }

        public Builder station(String station) {
            this.station = station;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder sceneType( String sceneType){
            this.sceneType = sceneType;
            return this;
        }



        public Builder copy(Exhibit exhibit){
            this.id = exhibit.getId();
            this.casNumber = exhibit.getCasNumber();
            this.station = exhibit.getStation();
            this.description = exhibit.getDescription();
            this.sceneType = exhibit.getSceneType();

            return this;
        }
        public Exhibit build() {
            return new Exhibit(this);
        }
    }


}
