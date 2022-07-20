package ru.korobov;

import java.util.*;

public class User {
    private int id;
    private String name;
    private int age;
    private Sex sex;

    public static Map<Integer, User> allUsers;
    private static int countId = 0;

    public User(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;

        if (allUsers == null) {
            allUsers = new HashMap<>();
        }

        if (!hasUser()){
            countId++;
            this.id = countId;
            allUsers.put(id, this);
        }
    }
    private boolean hasUser(){
        for (User user : allUsers.values()){
            if (user.equals(this) && user.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

//    public static Map<Integer, User> getAllUsers() {
//        return allUsers;
//    }
//
//    public static void setAllUsers(Map<Integer, User> allUsers) {
//        User.allUsers = allUsers;
//    }

    public static int getCountId() {
        return countId;
    }

    public static void setCountId(int countId) {
        User.countId = countId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && name.equals(user.name) && sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sex);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public static List<User> getAllUsers(){
        return new ArrayList<>(allUsers.values());
    }

    public static List<User> getAllUsers(Sex sex){
        List<User> listAllUsers = new ArrayList<>();
        for (User user : allUsers.values()){
            if (user.sex == sex){
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }

    public static int getHowManyUsers(){
        return allUsers.size();
    }

    public static int getHowManyUsers(Sex sex){
        return getAllUsers(sex).size();
    }

    public static int getAllAgeUsers(){
        int countAge = 0;
        for (User user : allUsers.values()){
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAllAgeUsers(Sex sex){
        int countAge = 0;
        for (User user : getAllUsers(sex)){
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAverageAgeOfAllUsers(){
        return getAllAgeUsers() / getHowManyUsers();
    }

    public static int getAverageAgeOfAllUsers(Sex sex){
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }






}


