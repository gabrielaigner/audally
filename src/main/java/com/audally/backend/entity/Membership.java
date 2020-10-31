package com.audally.backend.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@NotNull
public class Membership extends PanacheEntity {
    public MembershipType membershipType;
    public Date subscriptionDate;
    public Date expiryDate;
    public boolean cancelSubscription = false;
    @ManyToOne
    public User user;
}
