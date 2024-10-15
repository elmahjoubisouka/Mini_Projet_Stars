package com.example.tp_star.service;

import com.example.tp_star.beans.Star;
import com.example.tp_star.dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class StarService implements IDao<Star> {
    private List<Star> stars = new ArrayList<>();
    private static StarService instance;

    private StarService() { }

    public static StarService getInstance() {
        if (instance == null) {
            instance = new StarService();
        }
        return instance;
    }

    @Override
    public boolean create(Star o) {
        return stars.add(o);
    }

    @Override
    public boolean update(Star o) {
        for (Star s : stars) {
            if (s.getId() == o.getId()) {
                s.setImageResource(o.getImageResource());
                s.setName(o.getName());
                s.setStarRating(o.getStarRating());
                return true; // Ajout d'une condition de retour
            }
        }
        return false; // Renvoie false si aucune mise à jour n'a eu lieu
    }

    @Override
    public boolean delete(Star o) {
        return stars.remove(o);
    }

    @Override
    public Star findById(int id) {
        for (Star s : stars) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Star> findAll() {
        return stars;
    }
}
