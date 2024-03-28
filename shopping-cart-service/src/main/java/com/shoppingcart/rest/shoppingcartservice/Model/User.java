package com.shoppingcart.rest.shoppingcartservice.Model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;



@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotEmpty(message = "Name should not be null")
    private String userName;

    @Column(unique = true)
    @NotEmpty(message = "Mobile no should not be null")
    @Size(min = 10, max = 10, message = "mobile number must be 10 digit")
    private String userMobileNo;

    @Column(unique = true)
    @Email(message = "Email is not valid")
    @NotEmpty(message = "Email id should not be empty")
    private String userEmailId;

    
    @NotEmpty(message = "Password should not be null")
    private String userPassword;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE", joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "cart-user")
    private Cart cart;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "order-user")
    private List<Order> order;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "address-user")
    private List<Address> address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "wishlist-user")
    private WishList wishList;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "productreview-user")
    private List<ProductReview> review;

    public User(int userId, String userName, String userMobileNo, String userEmailId, String userPassword,
            Set<Role> roles, Cart cart, List<Order> order, List<Address> address, WishList wishList) {
        this.userId = userId;
        this.userName = userName;
        this.userMobileNo = userMobileNo;
        this.userEmailId = userEmailId;
        this.userPassword = userPassword;
        this.roles = roles;
        this.cart = cart;
        this.order = order;
        this.address = address;
        this.wishList = wishList;
    }

    public User() {
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobileNo() {
        return userMobileNo;
    }

    public void setUserMobileNo(String userMobileNo) {
        this.userMobileNo = userMobileNo;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities =  this.roles.stream().map(  (role) -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList()); 
      
        return authorities;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        
        return this.userPassword;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        
        return this.userEmailId;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        
       return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
       
       return true;
    }

}