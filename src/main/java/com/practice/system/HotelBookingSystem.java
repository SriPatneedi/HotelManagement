package com.practice.system;

//import com.practice.exception.BookingException;


public class HotelBookingSystem {
    /*@Getter
    private List<Hotel> hotels = new ArrayList<>();

    /**
     *
     * @param location location
     * @param date date
     * @param roomType roomtype
     * @return list of hotels based on the input
     * @throws BookingException when the input date is in the past
     * or when the location is null
     *//*
    public List<Hotel> searchHotels(final String location,
                                    final LocalDate date,
                                    final Hotel.ROOMTYPE roomType) {
        if (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now())) {
            throw new BookingException("Invalid Date!");
        }
        if (location == "") {
            throw new BookingException("Location cannot be empty!");
        }
        List<Hotel> currAvailableHotels = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getAvailableRooms().containsKey(date)) {
                if (hotel.getLocation() == location
                        && hotel.getAvailability().get(roomType) > 0) {
                    currAvailableHotels.add(hotel);
                }
            }
        }
        return  currAvailableHotels;
    }

    /**
     * Books a room.
     * @param hotel
     * @param guest
     * @param date
     * @param noOfRooms
     * @param noOfDays
     * @param paymentType
     * @return created booking
     * @throws IllegalArgumentException when hotel is null
     *//*
    public Booking bookRoom(final Hotel hotel,
                            final Guest guest,
                            final Map<Hotel.ROOMTYPE, Integer> noOfRooms,
                            final LocalDate date,
                            final int noOfDays,
                            final Payment.PAYMENTTYPE paymentType) {
        if (hotel == null) {
            throw new BookingException("hotel cant be null.");
        }
        if (noOfDays <= 0) {
            throw new BookingException("no of days should be positive.");
        }
        int amount = 0;
        for (Map.Entry<Hotel.ROOMTYPE, Integer> entry : noOfRooms.entrySet()) {
            Hotel.ROOMTYPE roomType = entry.getKey();
            try {
                int availableRoomsOfRoomtype
                        = hotel.getAvailability().get(roomType);
                Integer roomCount = entry.getValue();
                if (availableRoomsOfRoomtype < roomCount) {
                    System.out.println("Rooms not available to book");
                    return null;
                }
                amount += hotel.getRoomPrices().get(roomType) * roomCount;
            } catch (NullPointerException nullPointerException) {
                return null;
            } catch (ClassCastException classCastException) {

            } catch (Exception e) {

            } finally {
                System.out.println("Completed booking method");
            }
        }

        Payment payment = new Payment();
        try {
            if (payment.makePayment(amount, paymentType)
                    == Payment.PAYMENTSTATUS.SUCCESSFUL) {
                System.out.println("PAYMENT SUCCESSFUL");
                List<String> roomNos = availableRooms(hotel, noOfRooms);
                return createBooking(hotel, guest, date,
                        noOfDays, roomNos);
            }
        } catch (PaymentException exception) {
            System.out.println("Payment failed due to"
                    + exception.getMessage());
        }
        return null;
    }

    private static List<String> availableRooms(final Hotel hotel,
                                               final Map<Hotel.ROOMTYPE,
                                                       Integer> noOfRooms) {
        List<String> roomNos = new ArrayList<>();
        for (Map.Entry<Hotel.ROOMTYPE, Integer> entry : noOfRooms.entrySet()) {
            Hotel.ROOMTYPE roomType = entry.getKey();
            Integer roomCount = entry.getValue();
            List<Room> rooms = null;
            try {
                 rooms = hotel.getRooms(roomType);
            } catch (Exception exception) {
                System.out.println("unable to get the available rooms"
                        + exception.getMessage());
            }

            for (Room room : rooms) {
                if (roomCount == 0) {
                    break;
                }
                if (room.getRoomStatus() == Room.STATUS.AVAILABLE) {
                    roomNos.add(room.getRoomNo());
                    room.setRoomStatus(Room.STATUS.RESERVED);
                    roomCount--;
                }
            }
        }

        return roomNos;
    }

    /**
     *
     * @param hotel
     * @param guest
     * @param date
     * @param noOfDays
     * @param roomNos
     * @return Booking
     *//*
    private static Booking createBooking(final Hotel hotel,
                                         final Guest guest,
                                         final LocalDate date,
                                         final int noOfDays,
                                         final List<String> roomNos) {
        Booking booking = new Booking();
        booking.setCheckInDate(date);
        booking.setCheckOutDate(date.plusDays(noOfDays));
        booking.setGuestDetails(guest);
        booking.setHotelDetails(hotel);
        booking.getRoomDetails().addAll(roomNos);
        return booking;
    }

    /**
     *
     * @param hotel
     * @param bookingId
     * @throws BookingException if booking Id is empty
     * @throws RuntimeException if hotel is null
     *//*
    public void cancelBooking(final Hotel hotel,
                              final String bookingId) {
        if (hotel == null) {
            throw new RuntimeException();
        }

        if (bookingId == "") {
            throw new BookingException("Invalid Booking Id");
        }
        hotel.getBooking().remove(bookingId);
    }

    /**
     *
     * @param hotel
     * @param bookingId
     * @param date
     * @param noOfDays
     * @throws BookingException if the hotel or
     * bookingId is null/if date is in the past
     *//*
    public void modifyBooking(final Hotel hotel,
                              final String bookingId,
                              final LocalDate date,
                              final int noOfDays) {
        if (hotel == null) {
            throw new BookingException("Invalid Hotel");
        }
        if (bookingId == "") {
            throw new BookingException("Invalid bookingId!");
        }
        if (date.isBefore(LocalDate.now())) {
            throw new BookingException("Invalid Date! "
                    + "Date should be in future.");
        }
        Booking booking = hotel.getBooking().get(bookingId);
        Period period = Period.between(booking.getCheckInDate(),
                booking.getCheckOutDate());
        int totalDays = period.getDays()
                + period.getMonths()
                * LocalDate.now().lengthOfMonth()
                + period.getYears()
                * LocalDate.now().lengthOfYear();
        if (totalDays == noOfDays) {
            booking.setCheckInDate(date);
            booking.setCheckOutDate(date.plusDays(noOfDays));
        } else {
            System.out.println("Unable to modify!");
            throw new BookingException("Invalid no Of days!");
        }
    }*/
}
