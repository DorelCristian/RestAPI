package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "cursa")
public class Cursa extends EntitySpring<Integer> {

    @Column(name = "destinatie", nullable = false)
    private String destinatie;

    @Column(name = "date", nullable = false)
    private String date;

    /*@Column(name = "ora", nullable = false)
    private Time ora;*/



 // Default constructor required by JPA
    public Cursa() {
    }

    public Cursa(String destinatie, String date) {
        this.destinatie=destinatie;
        this.date=date;
       // this.ora=ora;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public String  getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date =date;
    }

  /*  public Time getOra() {
        return ora;
    }

    public void setTime(Time ora) {
        this.ora =ora;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cursa that=(Cursa) o;
        //Competition that = (Competition) o;
        return Objects.equals(destinatie, that.destinatie) &&
                Objects.equals(date, that.date) ;

    }

    @Override
    public int hashCode() {

        return Objects.hash(destinatie, date);
    }

    @Override
    public String toString() {
        return "Cursa{" +
                "destinatie='" + destinatie + '\'' +
                ", date=" + date +

                '}';
    }

}






















