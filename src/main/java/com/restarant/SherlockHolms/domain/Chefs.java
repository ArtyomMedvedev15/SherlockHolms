package com.restarant.SherlockHolms.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "OurChefs_Table")
public class Chefs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String FullName;

    @ElementCollection(targetClass = PositionChef.class, fetch = FetchType.EAGER)
    @CollectionTable(name="Position_Chefs",joinColumns = @JoinColumn(name = "PosCh_id"))
    @Enumerated(EnumType.STRING)
    private Set<PositionChef>positionChefs;

    private String filenameAvatarChefs;

    public Chefs() { }

    public Chefs(String fullName, Set<PositionChef> positionChefs, String filenameAvatarChefs) {
        FullName = fullName;
        this.positionChefs = positionChefs;
        this.filenameAvatarChefs = filenameAvatarChefs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Set<PositionChef> getPositionChefs() {
        return positionChefs;
    }

    public void setPositionChefs(Set<PositionChef> positionChefs) {
        this.positionChefs = positionChefs;
    }

    public String getFilenameAvatarChefs() {
        return filenameAvatarChefs;
    }

    public void setFilenameAvatarChefs(String filenameAvatarChefs) {
        this.filenameAvatarChefs = filenameAvatarChefs;
    }
}
