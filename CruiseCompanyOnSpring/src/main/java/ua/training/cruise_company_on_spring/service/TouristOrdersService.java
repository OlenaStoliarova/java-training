package ua.training.cruise_company_on_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.training.cruise_company_on_spring.dto.UserOrderDTO;
import ua.training.cruise_company_on_spring.entity.*;
import ua.training.cruise_company_on_spring.repository.ExcursionRepository;
import ua.training.cruise_company_on_spring.repository.OrderRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TouristOrdersService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ExcursionRepository excursionRepository;

    public List<UserOrderDTO> allOrdersOfUser(Long userId) {
        return orderRepository.findByUser_IdOrderByCreationDateDesc(userId).stream().map(TouristOrdersService::orderToDTO).collect(Collectors.toList());
    }

    @Transactional
    public void payOrder(Long orderId){
        Optional<Order> orderFromDB = orderRepository.findById(orderId);

        if (orderFromDB.isPresent()) {
            Order order = orderFromDB.get();
            order.setStatus(OrderStatus.PAID);
            orderRepository.save(order);
        }
    }

    public List<Excursion> allExcursionsForCruise(Long orderId) throws NoEntityFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new NoEntityFoundException("There is no order with provided id (" + orderId + ")"));
        List<Long> portIds = order.getCruise().getShip().getVisitingPorts().stream().map(Seaport::getId).collect(Collectors.toList());
        return excursionRepository.findBySeaport_IdIn(portIds);
    }

    @Transactional
    public void addExcursionsToOrder(Long orderId, List<Long> excursionsIds) throws NoEntityFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new NoEntityFoundException("There is no order with provided id (" + orderId + ")"));
        if( ! excursionsIds.isEmpty()){
            Set<Excursion> excursionsSet = new HashSet<>(excursionRepository.findByIdIn(excursionsIds));
            order.setExcursions(excursionsSet);
        }
        order.setStatus(OrderStatus.EXCURSIONS_ADDED);
        orderRepository.save(order);
    }


    static UserOrderDTO orderToDTO(Order order){
        UserOrderDTO result = UserOrderDTO.builder()
                .orderId(order.getId())
                .orderDate(order.getCreationDate())
                .routeNameEn(order.getCruise().getShip().getRouteNameEn())
                .routeNameUkr(order.getCruise().getShip().getRouteNameUkr())
                .cruiseStartingDate(order.getCruise().getStartingDate())
                .cruiseFinishingDate( order.getCruise().getStartingDate().plusDays( order.getCruise().getShip().getOneTripDurationDays()))
                .quantity(order.getQuantity())
                .totalPrice(order.getTotalPrice())
                .status(order.getStatus())
                .build();

        if( !order.getExcursions().isEmpty()){
            Set<Excursion> excursions = order.getExcursions();
            StringBuilder excursionsEn = new StringBuilder();
            StringBuilder excursionsUkr = new StringBuilder();
            for( Excursion excursion: excursions){
                excursionsEn.append(excursion.getNameEn());
                excursionsEn.append(", ");
                excursionsUkr.append(excursion.getNameUkr());
                excursionsUkr.append(", ");
            }
            excursionsEn.replace( excursionsEn.lastIndexOf(","), excursionsEn.length(), "");
            excursionsUkr.replace( excursionsUkr.lastIndexOf(","), excursionsUkr.length(), "");
            result.setAddedExcursionsEn(excursionsEn.toString());
            result.setAddedExcursionsUkr(excursionsUkr.toString());
        } else if (order.getStatus().compareTo( OrderStatus.EXCURSIONS_ADDED) >= 0){
            result.setAddedExcursionsEn("-");
            result.setAddedExcursionsUkr("-");
        }

        if( !order.getFreeExtras().isEmpty()){
            Set<Extra> extras = order.getFreeExtras();
            StringBuilder extrasEn = new StringBuilder();
            StringBuilder extrasUkr = new StringBuilder();
            for( Extra bonus: extras){
                extrasEn.append( bonus.getNameEn());
                extrasEn.append(", ");
                extrasUkr.append( bonus.getNameUkr());
                extrasUkr.append(", ");
            }
            extrasEn.replace( extrasEn.lastIndexOf(","), extrasEn.length(), "");
            extrasUkr.replace( extrasUkr.lastIndexOf(","), extrasUkr.length(), "");
            result.setFreeExtrasEn(extrasEn.toString());
            result.setFreeExtrasUkr(extrasUkr.toString());
        } else if (order.getStatus() == OrderStatus.EXTRAS_ADDED){
            result.setFreeExtrasEn("-");
            result.setFreeExtrasUkr("-");
        }

        return result;
    }

}
