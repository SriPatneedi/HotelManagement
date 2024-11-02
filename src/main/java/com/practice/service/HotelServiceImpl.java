package com.practice.service;

import com.practice.entity.Hotel;
import com.practice.entity.Room;
import com.practice.repository.HotelRepository;
import com.practice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{
    private HotelRepository hotelRepository;
    private RoomRepository roomRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository, RoomRepository roomRepository){
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;

    }

    @Override
    public List<Hotel> getBy(String name, String location) {
        /*if((name == null || name.isBlank()) && (location == null || location.isBlank())){
            return hotelRepository.findAll();
        } else if (name == null || location == null) {
            return hotelRepository.findByNameIsNullOrLocationIsNull(name, location);
        }*/
        /*Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setLocation(location);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        Example<Hotel> example = Example.of(hotel,matcher);*/
        Specification<Hotel> specification = constructSpecification(name, location);
        return hotelRepository.findAll(specification);
    }

    private Specification<Hotel> constructSpecification(String name, String location){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(name != null && !name.isBlank()){
                Predicate predicate = criteriaBuilder.equal(root.get("name"), name);
                predicates.add(predicate);
            }
            if(location != null && !location.isBlank()){
                Predicate predicate = criteriaBuilder.equal(root.get("location"),location);
                predicates.add(predicate);
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public Hotel getById(int id){
        return hotelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity with id supplied not found."));
    }

    public List<Room> getRooms(int id, Hotel.ROOMTYPE type){
        return roomRepository.findByTypeAndHotelIdAndStatus(type,id, Room.STATUS.AVAILABLE);
    }

    public Hotel addHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    @Override
    public void deleteById(int id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        hotelRepository.deleteAll();
    }

    public List<Room> getAvailableRooms(Hotel.ROOMTYPE type){
        return hotelRepository.findAvailableRooms(type);
    }
}
